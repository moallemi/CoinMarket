package me.moallemi.coinmarket.app.executor

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import me.moallemi.coinmarket.domain.executer.PostExecutorThread

class MainThread : PostExecutorThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}