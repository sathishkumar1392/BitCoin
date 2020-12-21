package com.sathish.bitcoin.ui.bitcoinchartlist

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.data.LineData
import com.sathish.bitcoin.Base.BaseFragment
import com.sathish.bitcoin.R
import com.sathish.bitcoin.databinding.FragmentBitcoinchartListBinding
import javax.inject.Inject

class BitCoinChartListFragment : BaseFragment<FragmentBitcoinchartListBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: BitCoinChartListViewModel by viewModels {
        viewModelFactory
    }

    override fun getLayoutId(): Int = R.layout.fragment_bitcoinchart_list

    private lateinit var binding: FragmentBitcoinchartListBinding


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding = getDataBinding()
        viewModel.getBitCoinList()
        setWidth()
        observerViewModel()
    }

    @Suppress("DEPRECATION")
    private fun setWidth() {
        val displayMetrics = DisplayMetrics()
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            val display = activity?.display
            display?.getRealMetrics(displayMetrics)
        } else {
            val display = activity?.windowManager?.defaultDisplay
            display?.getMetrics(displayMetrics)
        }
    }


    private fun observerViewModel() {
        viewModel.bitCoinLiveData.observe(requireActivity(), chartObserver)
        viewModel.errorMessage.observe(requireActivity(), {
            clearChart()
        })
    }

    private val chartObserver = Observer<LineData> { lineData ->
        binding.progressBar.visibility = View.GONE
        if (lineData == null) {
            clearChart()
        } else {
            binding.chart.data = lineData
            binding.chart.animateX(800)
        }
    }

    // clear chart data
    private fun clearChart() {
        binding.chart.data = null
        binding.chart.isEnabled = false
        binding.chart.invalidate()
        binding.chart.setNoDataText(getString(R.string.noChartDataString))
        binding.progressBar.visibility = View.GONE
    }
}


