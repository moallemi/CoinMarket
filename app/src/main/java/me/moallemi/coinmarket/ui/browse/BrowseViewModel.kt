package me.moallemi.coinmarket.ui.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.moallemi.coinmarket.domain.interactor.GetLatestUseCase
import me.moallemi.coinmarket.domain.model.CurrencyInfo
import me.moallemi.coinmarket.ui.base.BaseViewModel

class BrowseViewModel(private val getLatestUseCase: GetLatestUseCase) : BaseViewModel() {

    init {
        useCases += getLatestUseCase
    }

    private val _items = MutableLiveData<List<CurrencyInfo>>()
    val items: LiveData<List<CurrencyInfo>> = _items

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun load() {
        getLatestUseCase.execute(GetLatestUseCase.None(), ::success, ::error)
    }

    fun success(items: List<CurrencyInfo>) {
        _items.value = items
    }

    fun error(error: Throwable) {
        _error.value = error
    }
}