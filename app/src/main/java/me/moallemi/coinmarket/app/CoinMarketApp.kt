package me.moallemi.coinmarket.app

import android.app.Application
import me.moallemi.coinmarket.di.component.AppComponent
import me.moallemi.coinmarket.di.component.DaggerAppComponent
import me.moallemi.coinmarket.di.module.AppModule

class CoinMarketApp : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}