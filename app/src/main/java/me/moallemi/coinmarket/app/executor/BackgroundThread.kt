package me.moallemi.coinmarket.app.executor

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import me.moallemi.coinmarket.domain.executer.UseCaseExecutorThread

class BackgroundThread : UseCaseExecutorThread {
    override val scheduler: Scheduler
        get() = Schedulers.io()
}