package me.moallemi.coinmarket.domain.interactor

import io.reactivex.Single
import me.moallemi.coinmarket.domain.executer.PostExecutorThread
import me.moallemi.coinmarket.domain.executer.UseCaseExecutorThread
import me.moallemi.coinmarket.domain.interactor.base.SingleUseCase
import me.moallemi.coinmarket.domain.model.CurrencyInfo
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository

class GetLatestUseCase(
    private val coinMarketRepository: CoinMarketRepository,
    useCaseExecutorThread: UseCaseExecutorThread,
    postExecutorThread: PostExecutorThread
) :
    SingleUseCase<GetLatestUseCase.None, List<CurrencyInfo>>(useCaseExecutorThread, postExecutorThread) {

    override fun buildSingle(params: None): Single<List<CurrencyInfo>> {
        return coinMarketRepository.getLatest()
    }

    class None
}