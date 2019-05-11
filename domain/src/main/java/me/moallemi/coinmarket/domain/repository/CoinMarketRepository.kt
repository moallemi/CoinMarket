package me.moallemi.coinmarket.domain.repository

import io.reactivex.Single
import me.moallemi.coinmarket.domain.model.CurrencyInfo

interface CoinMarketRepository {

    fun getLatest(): Single<List<CurrencyInfo>>
}