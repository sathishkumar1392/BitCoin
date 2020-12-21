package com.sathish.bitcoin.domain.model




data class BitCoin(
    val description: String,
    val name: String,
    val period: String,
    val status: String,
    val unit: String,
    var Values: List<ChartValue>
)


data class ChartValue(
    val x: Int,
    val y: Double
)