package com.sathish.bitcoin.di

import com.sathish.bitcoin.BuildConfig
import com.sathish.bitcoin.data.BitCoinService
import com.sathish.bitcoin.model.BitCoinMapper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
     fun providesCoinMarketCapApi(retrofit: Retrofit) =
        retrofit.create(BitCoinService::class.java)

    @Provides
    @Singleton
     fun providesOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()


    @Singleton
    @Provides
    fun provideRecipeMapper(): BitCoinMapper {
        return BitCoinMapper()
    }
}