package com.sathish.bitcoin.useCaseTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sathish.bitcoin.common.mock
import com.sathish.bitcoin.common.whenever
import com.sathish.bitcoin.domain.BitCoinChartInteractor
import com.sathish.bitcoin.domain.BitCoinRepository
import com.sathish.bitcoin.domain.model.BitCoin
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test

class BitCoinChartListUseCasesUnitTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private  val bitCoinRepository = mock<BitCoinRepository>()

    private val bitCoinUseCases by lazy { BitCoinChartInteractor(bitCoinRepository) }

    private val response = BitCoin("", "", "", "", "", emptyList())

    @Test
    fun `test the Bit coin chart list getBitCoinChartList Completed`() {
        whenever(bitCoinRepository.getBitCoinChartList())
            .thenReturn(Single.just(response))

        bitCoinUseCases.getBitCoinChartList()
            .test()
            .assertComplete()
    }

    @Test
    fun `test the Bit coin chart list getBitCoinChartList Error`() {
        val response = Throwable("Error response")
        whenever(bitCoinRepository.getBitCoinChartList())
            .thenReturn(Single.error(response))

        bitCoinUseCases.getBitCoinChartList()
            .test()
            .assertError(response)
    }

    @Test
    fun `test the Bit coin chart list getBitCoinChartList Response`() {
        whenever(bitCoinRepository.getBitCoinChartList())
            .thenReturn(Single.just(response))

        val expectedList = response

        bitCoinUseCases.getBitCoinChartList()
            .test()
            .assertValue(expectedList)
    }

}