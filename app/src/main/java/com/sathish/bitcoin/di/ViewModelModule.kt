package com.sathish.bitcoin.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sathish.bitcoin.ui.ViewModelFactory
import com.sathish.bitcoin.ui.bitcoinchartlist.BitCoinChartListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BitCoinChartListViewModel::class)
    abstract fun bindViewModel(bitCoinChartListViewModel: BitCoinChartListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
