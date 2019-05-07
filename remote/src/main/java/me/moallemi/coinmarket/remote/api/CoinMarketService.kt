package me.moallemi.coinmarket.remote.api

import io.reactivex.Single
import me.moallemi.coinmarket.remote.dto.ListingsDto
import retrofit2.http.GET

interface CoinMarketService {
    @GET("/v1/cryptocurrency/listings/latest")
    fun getLatest(): Single<ListingsDto>

    companion object {
        const val BASE_URL = "https://pro-api.coinmarketcap.com"
    }
}