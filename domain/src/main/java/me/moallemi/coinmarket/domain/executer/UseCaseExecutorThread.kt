package me.moallemi.coinmarket.domain.executer

import io.reactivex.Scheduler

interface UseCaseExecutorThread {
    val scheduler: Scheduler
}