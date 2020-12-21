package com.sathish.bitcoin.data

import com.sathish.bitcoin.model.BitCoinEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BitCoinService {
    @GET("charts/transactions-per-second?")
    fun getBitCoinChartList():Single<BitCoinEntity>

}