package me.moallemi.coinmarket.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.moallemi.coinmarket.ui.browse.BrowseFragment

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun browseFragment(): BrowseFragment
}