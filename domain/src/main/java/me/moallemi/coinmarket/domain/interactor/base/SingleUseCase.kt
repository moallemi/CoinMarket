package me.moallemi.coinmarket.domain.interactor.base

import io.reactivex.Single
import me.moallemi.coinmarket.domain.executer.PostExecutorThread
import me.moallemi.coinmarket.domain.executer.UseCaseExecutorThread

abstract class SingleUseCase<in Params, Result>(
    private val useCaseExecutorThread: UseCaseExecutorThread,
    private val postExecutorThread: PostExecutorThread
) : UseCase() {

    abstract fun buildSingle(params: Params): Single<Result>

    fun execute(
        params: Params,
        success: (Result) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        buildSingle(params)
            .observeOn(postExecutorThread.scheduler)
            .subscribeOn(useCaseExecutorThread.scheduler)
            .subscribe({
                success(it)
            }, {
                failure(it)
            }).also {
                add(it)
            }
    }

}