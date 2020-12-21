package com.sathish.bitcoin.domain

import com.sathish.bitcoin.domain.model.BitCoin
import io.reactivex.Single


class BitCoinChartInteractor(private val bitCoinRepository: BitCoinRepository) :
    BitCoinChartUseCases {
    override fun getBitCoinChartList(): Single<BitCoin> {
        return bitCoinRepository.getBitCoinChartList()
    }
}