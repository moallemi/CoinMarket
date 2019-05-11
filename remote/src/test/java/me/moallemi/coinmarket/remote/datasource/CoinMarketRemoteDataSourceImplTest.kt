package me.moallemi.coinmarket.remote.datasource

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import me.moallemi.coinmarket.remote.api.CoinMarketService
import me.moallemi.coinmarket.remote.dto.ListingsDto
import me.moallemi.coinmarket.remote.dto.StatusDto
import me.moallemi.coinmarket.remote.dto.toCurrencyInfoEntityList
import org.junit.Before
import org.junit.Test
import java.io.IOException

class CoinMarketRemoteDataSourceImplTest {

    private val service: CoinMarketService = mockk()
    private val dateSource = CoinMarketRemoteDataSourceImpl(service)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `getLatest when successful`() {
        // Given
        val listingsDto = ListingsDto(
            listOf(),
            StatusDto(0, 0, 0, "", "")
        )
        every { service.getLatest() } returns Single.just(listingsDto)

        // When, Then

        dateSource.getLatest()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(listingsDto.toCurrencyInfoEntityList())
    }

    @Test
    fun `getLatest when fails`() {
        every { service.getLatest() } returns Single.error(IOException())

        dateSource.getLatest()
            .test()
            .assertNotComplete()
            .assertFailure(IOException::class.java)
    }
}