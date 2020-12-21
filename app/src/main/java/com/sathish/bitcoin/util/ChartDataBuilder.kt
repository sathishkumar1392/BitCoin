package com.sathish.bitcoin.util


import android.content.Context
import androidx.core.content.res.ResourcesCompat
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.sathish.bitcoin.R
import javax.inject.Inject

class ChartDataBuilder @Inject constructor(
    private var context: Context,
) {
    private var chartFillColor: Int = 0
    private var chartBorderColor: Int = 0
    private var percentageColor: Int = 0


    fun setColors(percentChange: Float) {
        if (percentChange >= 0) {
            chartFillColor = ResourcesCompat.getColor(
                context.resources, R.color.materialLightGreen, null
            )
            chartBorderColor =
                ResourcesCompat.getColor(context.resources, R.color.darkGreen, null)
            percentageColor = ResourcesCompat.getColor(
                context.resources,
                R.color.percentPositiveGreen,
                null
            )
        } else {
            chartFillColor = ResourcesCompat.getColor(
                context.resources,
                R.color.materialLightRed,
                null
            )
            chartBorderColor =
                ResourcesCompat.getColor(context.resources, R.color.darkRed, null)
            percentageColor = ResourcesCompat.getColor(
                context.resources,
                R.color.percentNegativeRed,
                null
            )
        }
    }


    fun setUpLineDataSet(entries: List<Entry>): LineDataSet {
        val dataSet = LineDataSet(entries, "Price")
        dataSet.color = chartBorderColor
        dataSet.fillColor = chartFillColor
        dataSet.setDrawHighlightIndicators(true)
        dataSet.setDrawFilled(true)
        dataSet.setDrawCircles(true)
        dataSet.setCircleColor(chartBorderColor)
        dataSet.setDrawCircleHole(false)
        dataSet.setDrawValues(false)
        dataSet.circleRadius = 1f
        dataSet.highlightLineWidth = 2f
        dataSet.isHighlightEnabled = true
        dataSet.setDrawHighlightIndicators(true)
        dataSet.highLightColor = chartBorderColor
        return dataSet
    }

}