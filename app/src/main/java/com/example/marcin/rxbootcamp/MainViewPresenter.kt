package com.example.marcin.rxbootcamp

import com.example.marcin.rxbootcamp.Model.ApiHandler
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


/**
 * Created by Marcin on 20.09.2017.
 */
class MainViewPresenter(val view: Contracts.MainView) : Contracts.MainViewPresenter {

    val apiHandler = ApiHandler()

    override fun onViewCreated(observable: Observable<CharSequence>) {
        observable.debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onNext = { apiHandler.getPosts(it.toString()).subscribe()}
                )
                .
/*
        apiHandler.getPosts("bruno")
                .subscribeOn(Schedulers.io())
                .subscribeBy {
                    println(it)
                }*/
    }

}