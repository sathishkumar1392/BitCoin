package com.sathish.bitcoin.di

import com.sathish.bitcoin.domain.BitCoinChartInteractor
import com.sathish.bitcoin.domain.BitCoinChartUseCases
import com.sathish.bitcoin.domain.BitCoinRepository
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun providesBitCoinChatListUseCases(bitCoinRepository: BitCoinRepository): BitCoinChartUseCases =
        BitCoinChartInteractor(bitCoinRepository)
}