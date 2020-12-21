package com.sathish.bitcoin.di

import android.app.Application
import android.content.Context
import com.sathish.bitcoin.BitCoinApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class,
        AndroidInjectionModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        UseCasesModule::class,
        MainActivityModule::class]
)
interface AppComponent : AndroidInjector<BitCoinApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent

    }

    override fun inject(bitcoinapp: BitCoinApplication?)
}
