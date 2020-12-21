package com.sathish.bitcoin.domain

import com.sathish.bitcoin.domain.model.BitCoin
import io.reactivex.Single

interface BitCoinRepository {
    fun getBitCoinChartList(): Single<BitCoin>
}