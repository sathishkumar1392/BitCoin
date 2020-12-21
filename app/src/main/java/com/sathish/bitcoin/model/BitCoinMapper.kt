package com.sathish.bitcoin.model

import com.sathish.bitcoin.domain.model.BitCoin
import com.sathish.bitcoin.domain.model.ChartValue
import com.sathish.bitcoin.util.EntityMapper
import io.reactivex.Single

class BitCoinMapper : EntityMapper<BitCoinEntity, BitCoin> {
    override fun mapFromEntity(entity: BitCoinEntity): BitCoin {
        val valuesList = mutableListOf<ChartValue>()

        entity.values.forEach {
            valuesList.add(ChartValue(it.x, it.y))
        }

        return BitCoin(
            description = entity.description,
            name = entity.name,
            period = entity.period,
            status = entity.status,
            unit = entity.unit,
            Values = valuesList
        )
    }

    fun fromEntity(initial: Single<BitCoinEntity>): Single<BitCoin> {
        return initial.map { mapFromEntity(it) }
    }

}