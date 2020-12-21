package com.sathish.bitcoin.domain

import com.sathish.bitcoin.domain.model.BitCoin
import io.reactivex.Single


interface BitCoinChartUseCases {
    fun getBitCoinChartList(): Single<BitCoin>
}

