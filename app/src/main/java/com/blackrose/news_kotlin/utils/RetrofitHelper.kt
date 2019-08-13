package com.blackrose.news_kotlin.utils

import com.blackrose.news_kotlin.models.Article
import com.blackrose.news_kotlin.models.NewsVO
import com.blackrose.news_kotlin.networks.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    var mService : ApiService

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mService = retrofit.create(ApiService::class.java)

    }

}