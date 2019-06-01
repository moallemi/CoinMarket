package me.moallemi.coinmarket.ui.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.moallemi.coinmarket.domain.interactor.GetLatestUseCase

class BrowseViewModelFactory(var getLatestUseCase: GetLatestUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BrowseViewModel(getLatestUseCase) as T
    }
}