package com.blackrose.news_kotlin.networks

import com.blackrose.news_kotlin.models.NewsVO
import com.blackrose.news_kotlin.models.SourceList
import com.blackrose.news_kotlin.models.SourceListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val APIKEY = "f1cc480eca694165a540367feb54f884"

interface ApiService {

    @GET("v2/everything")
    fun getNews(@Query("q") q: String,
                @Query("from") from: String,
                @Query("sortBy") sortBy: String,
                @Query("apiKey") apiKey: String = APIKEY): Call<NewsVO>

    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = APIKEY
    ): Call<NewsVO>

    @GET("v2/sources")
    fun loadSources(
        @Query("apiKey") apiKey: String = APIKEY
    ): Call<SourceListResponse>

}