package com.sathish.bitcoin.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sathish.bitcoin.common.mock
import com.sathish.bitcoin.common.whenever
import com.sathish.bitcoin.domain.BitCoinChartUseCases
import com.sathish.bitcoin.domain.BitCoinRepository
import com.sathish.bitcoin.domain.model.BitCoin
import com.sathish.bitcoin.ui.bitcoinchartlist.BitCoinChartListViewModel
import com.sathish.bitcoin.util.ChartDataBuilder
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class BitCoinChartListViewModelUnitTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()


    private val bitCoinListUseCases= mock<BitCoinChartUseCases>()
    private val appResource = mock<ChartDataBuilder>()

    private val viewModel by lazy { BitCoinChartListViewModel(bitCoinListUseCases, Schedulers.trampoline(), Schedulers.trampoline(),appResource) }


    @Before
    fun initTest() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun `test bit coin chart list on success response`() {
        val chartModel = BitCoin("", "", "", "", "", emptyList())
        val response =chartModel
        whenever(bitCoinListUseCases.getBitCoinChartList()).thenReturn(Single.just(response))
        viewModel.getBitCoinList()
        assertEquals(chartModel,response)
    }

    @Test
    fun `test bit coin chart list on Error response`() {
        val errorMessage = Throwable("Error response")
        val response = errorMessage
        whenever(bitCoinListUseCases.getBitCoinChartList()).thenReturn(Single.error(response))
        viewModel.getBitCoinList()
        assertEquals(errorMessage,response)
    }

    @Before
    fun setUpRxSchedulers() {

        val immediate = object : Scheduler() {

            override fun createWorker(): Worker {
                // return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

        RxJavaPlugins.setInitIoSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitComputationSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitSingleSchedulerHandler { scheduler -> immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> immediate }
    }

}