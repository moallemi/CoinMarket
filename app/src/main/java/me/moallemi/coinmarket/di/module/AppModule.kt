package me.moallemi.coinmarket.di.module

import dagger.Module
import dagger.Provides
import me.moallemi.coinmarket.app.CoinMarketApp
import me.moallemi.coinmarket.app.executor.BackgroundThread
import me.moallemi.coinmarket.app.executor.MainThread
import me.moallemi.coinmarket.domain.executer.PostExecutorThread
import me.moallemi.coinmarket.domain.executer.UseCaseExecutorThread

@Module
class AppModule(val app: CoinMarketApp) {

    @Provides
    fun provideContext(app: CoinMarketApp) = app.applicationContext

    @Provides
    fun provideMainThread(): PostExecutorThread = MainThread()

    @Provides
    fun provideBackgroundThread(): UseCaseExecutorThread = BackgroundThread()
}