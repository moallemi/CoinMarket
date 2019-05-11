package me.moallemi.coinmarket.data.datasource

import io.reactivex.Single
import me.moallemi.coinmarket.data.entity.CurrencyInfoEntity

interface CoinMarketRemoteDataSource {

    fun getLatest(): Single<List<CurrencyInfoEntity>>
}