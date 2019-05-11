package me.moallemi.coinmarket.domain.executer

import io.reactivex.Scheduler

interface PostExecutorThread {
    val scheduler: Scheduler
}