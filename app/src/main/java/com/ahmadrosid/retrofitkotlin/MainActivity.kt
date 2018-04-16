package com.ahmadrosid.retrofitkotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.ahmadrosid.retrofitkotlin.adapter.QuoteAdapter
import com.ahmadrosid.retrofitkotlin.model.Item
import com.ahmadrosid.retrofitkotlin.network.KutipApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Kutip.org"

        val apiService = KutipApiService.create()

        apiService.getQuote()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { loader.show() }
                .doOnComplete { loader.hide() }
                .doOnError { loader.hide() }
                .map { it.items }
                .subscribe(
                        { displayQuote(it) },
                        { displayError(it) }
                )

    }

    private fun displayQuote(quotes: List<Item>?){
        val adapter = QuoteAdapter()
        adapter.addData(quotes)
        listQuote.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    private fun displayError(throwable: Throwable?) {
        Snackbar.make(listQuote, "Failed to display list quote. \n ${throwable?.localizedMessage}", Snackbar.LENGTH_LONG).show()
    }

    private fun View.show() {
        this.visibility = VISIBLE
    }

    private fun View.hide() {
        this.visibility = GONE
    }
}
