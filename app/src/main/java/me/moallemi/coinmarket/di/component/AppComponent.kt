package me.moallemi.coinmarket.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import me.moallemi.coinmarket.app.CoinMarketApp
import me.moallemi.coinmarket.di.module.AppModule
import me.moallemi.coinmarket.di.module.BrowseModule
import me.moallemi.coinmarket.di.module.FragmentsModule
import me.moallemi.coinmarket.di.module.NetworkModule


@Component(
    modules = [
        AndroidInjectionModule::class,
        FragmentsModule::class,
        AppModule::class,
        BrowseModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<CoinMarketApp> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<CoinMarketApp>
}