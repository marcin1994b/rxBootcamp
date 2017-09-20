package com.example.marcin.rxbootcamp

import io.reactivex.Observable

/**
 * Created by Marcin on 20.09.2017.
 */
interface Contracts {

    interface MainView{

    }

    interface MainViewPresenter{

        fun onViewCreated(observable: Observable<CharSequence>)
    }
}