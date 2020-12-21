package com.sathish.bitcoin.model

import com.google.gson.annotations.SerializedName


data class BitCoinEntity(
    @SerializedName("description") val description: String,
    @SerializedName("name") val name: String,
    @SerializedName("period") val period: String,
    @SerializedName("status") val status: String,
    @SerializedName("unit") val unit: String,
    @SerializedName("values") val values: List<Value> = listOf()
)

data class Value(
    @SerializedName("x") val x: Int,
    @SerializedName("y") val y: Double
)