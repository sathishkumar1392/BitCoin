package com.sathish.bitcoin.ui.bitcoinchartlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.sathish.bitcoin.di.SCHEDULER_IO
import com.sathish.bitcoin.di.SCHEDULER_MAIN_THREAD
import com.sathish.bitcoin.domain.BitCoinChartUseCases
import com.sathish.bitcoin.domain.model.BitCoin
import com.sathish.bitcoin.util.ChartDataBuilder
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class BitCoinChartListViewModel @Inject constructor(
    private val bitCoinListUseCases: BitCoinChartUseCases,
    @Named(SCHEDULER_IO)
    private val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD)
    private val observeOnScheduler: Scheduler,
    private val appResourses: ChartDataBuilder
) : ViewModel() {
    private val disposable: CompositeDisposable = CompositeDisposable()
    private val _bitCoinLiveData: MutableLiveData<LineData> = MutableLiveData()
    val bitCoinLiveData: MutableLiveData<LineData> = _bitCoinLiveData
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun getBitCoinList() {
       // disposable.add(
            bitCoinListUseCases.getBitCoinChartList()
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(this::onBitCoinReceived, this::onError)
      //  )
    }


    fun onError(error: Throwable) {
        errorMessage.value = error.message
    }

    private fun onBitCoinReceived(bitcoin: BitCoin) {
        formChartData(bitcoin)
    }

    fun formChartData(bitcoin: BitCoin) {
        val closePrices = java.util.ArrayList<Entry>()

        for (priceTimeUnit in bitcoin.Values) {
            closePrices.add(Entry(priceTimeUnit.x.toFloat(), priceTimeUnit.y.toFloat()))
        }

        val currPrice = closePrices[closePrices.size - 1].y
        val firstPrice = closePrices[0].y
        val difference = currPrice - firstPrice
        val percentChange = difference / firstPrice * 100
        appResourses.setColors(percentChange)
        val dataSet = appResourses.setUpLineDataSet(closePrices)
        val lineData = LineData(dataSet)
        _bitCoinLiveData.postValue(lineData)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}