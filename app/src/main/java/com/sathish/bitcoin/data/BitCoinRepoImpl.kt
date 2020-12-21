package com.sathish.bitcoin.data

import com.sathish.bitcoin.domain.BitCoinRepository
import com.sathish.bitcoin.domain.model.BitCoin
import com.sathish.bitcoin.model.BitCoinMapper
import io.reactivex.Single

class BitCoinRepoImpl(private val apiService: BitCoinService, private val mapper: BitCoinMapper) :
    BitCoinRepository {
    override fun getBitCoinChartList(): Single<BitCoin> {
        return mapper.fromEntity(apiService.getBitCoinChartList())
    }

}