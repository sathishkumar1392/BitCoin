package com.sathish.bitcoin.di

import com.sathish.bitcoin.ui.bitcoinchartlist.BitCoinChartListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeFirstFragment(): BitCoinChartListFragment
}
