package me.moallemi.coinmarket.data.repository

import io.reactivex.Single
import me.moallemi.coinmarket.data.datasource.CoinMarketRemoteDataSource
import me.moallemi.coinmarket.data.entity.toCurrencyInfo
import me.moallemi.coinmarket.domain.model.CurrencyInfo
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository

class CoinMarketRepositoryImpl(
    private val coinMarketRemoteDataSource: CoinMarketRemoteDataSource
) : CoinMarketRepository {

    override fun getLatest(): Single<List<CurrencyInfo>> {
        return coinMarketRemoteDataSource.getLatest().map { items ->
            items.map { currencyInfoEntity ->
                currencyInfoEntity.toCurrencyInfo()
            }
        }
    }
}