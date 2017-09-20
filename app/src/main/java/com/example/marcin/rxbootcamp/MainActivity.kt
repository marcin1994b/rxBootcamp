package com.example.marcin.rxbootcamp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.widget.textChanges
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contracts.MainView {

    private lateinit var presenter : Contracts.MainViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainViewPresenter(this)
        presenter.onViewCreated(editText.textChanges())



    }
}
