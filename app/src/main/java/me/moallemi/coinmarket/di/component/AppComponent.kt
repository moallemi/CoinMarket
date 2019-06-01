package me.moallemi.coinmarket.di.component

import dagger.Component
import me.moallemi.coinmarket.di.module.AppModule
import me.moallemi.coinmarket.di.module.BrowseModule
import me.moallemi.coinmarket.di.module.NetworkModule
import me.moallemi.coinmarket.ui.browse.BrowseFragment


@Component(
    modules = [
        AppModule::class,
        BrowseModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {
    fun inject(browseFragment: BrowseFragment)
}