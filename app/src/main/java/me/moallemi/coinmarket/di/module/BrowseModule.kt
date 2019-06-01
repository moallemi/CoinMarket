package me.moallemi.coinmarket.di.module

import dagger.Module
import dagger.Provides
import me.moallemi.coinmarket.data.datasource.CoinMarketRemoteDataSource
import me.moallemi.coinmarket.data.repository.CoinMarketRepositoryImpl
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository
import me.moallemi.coinmarket.remote.api.CoinMarketService
import me.moallemi.coinmarket.remote.datasource.CoinMarketRemoteDataSourceImpl
import me.moallemi.coinmarket.ui.browse.BrowseFragment

@Module
class BrowseModule {

    @Provides
    fun provideCoinMarketRemoteDataSource(coinMarketService: CoinMarketService): CoinMarketRemoteDataSource {
        return CoinMarketRemoteDataSourceImpl(coinMarketService)
    }

    @Provides
    fun provideCoinMarketRepository(coinMarketRemoteDataSource: CoinMarketRemoteDataSource): CoinMarketRepository {
        return CoinMarketRepositoryImpl(coinMarketRemoteDataSource)
    }
}