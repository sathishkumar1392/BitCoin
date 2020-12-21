package com.sathish.bitcoin.di

import com.sathish.bitcoin.data.BitCoinRepoImpl
import com.sathish.bitcoin.data.BitCoinService
import com.sathish.bitcoin.domain.BitCoinRepository
import com.sathish.bitcoin.model.BitCoinMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesBitCoinRepository(
        bitCoinService: BitCoinService,
        mapper: BitCoinMapper
    ): BitCoinRepository = BitCoinRepoImpl(apiService = bitCoinService,mapper =  mapper)
}