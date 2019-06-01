package me.moallemi.coinmarket.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import me.moallemi.coinmarket.di.component.DaggerAppComponent

class CoinMarketApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}