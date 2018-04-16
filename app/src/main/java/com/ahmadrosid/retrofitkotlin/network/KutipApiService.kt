package com.ahmadrosid.retrofitkotlin.network

import com.ahmadrosid.retrofitkotlin.model.Quote
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by ocittwo on 4/17/18.
 */
interface KutipApiService {

    @GET("id/feed.json")
    fun getQuote(): Flowable<Quote>

    companion object Factory {
        fun create(): KutipApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://kutip.org/")
                    .build()
            return retrofit.create(KutipApiService::class.java)
        }
    }
}