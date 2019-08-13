package com.blackrose.news_kotlin.remote

import com.blackrose.news_kotlin.models.Article
import com.blackrose.news_kotlin.models.NewsVO
import com.blackrose.news_kotlin.models.SourceList
import com.blackrose.news_kotlin.models.SourceListResponse
import com.blackrose.news_kotlin.utils.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RemoteDataSource {

    fun loadNews(success : (List<Article>) -> Unit, fail : (String) -> Unit) {

        RetrofitHelper.mService.getNews("bitcoin", "2019-07-12", "publishedAt")
            .enqueue(object : Callback<NewsVO> {

                override fun onResponse(call: Call<NewsVO>, response: Response<NewsVO>) {
                    if (response.isSuccessful) {
                        response.body()?.apply {
                            success(this.articles)
                        } ?: fail("Your response is null.")
                    }
                }

                override fun onFailure(call: Call<NewsVO>, t: Throwable) {
                    fail(t.localizedMessage)
                }

            })

    }

    fun loadTopHeadlines (success: (List<Article>) -> Unit, fail: (String) -> Unit){
        RetrofitHelper.mService.getTopHeadlines("us","business")
            .enqueue(object : Callback<NewsVO>{
                override fun onResponse(call: Call<NewsVO>, response: Response<NewsVO>) {

                }

                override fun onFailure(call: Call<NewsVO>, t: Throwable) {

                }
            })
    }

    fun loadSources(success: (SourceListResponse) -> Unit, fail: (String) -> Unit){
        RetrofitHelper.mService.loadSources()
            .enqueue(object : Callback<SourceListResponse>{
                override fun onFailure(call: Call<SourceListResponse>, t: Throwable) {
                    fail(t.localizedMessage)
                }

                override fun onResponse(call: Call<SourceListResponse>, response: Response<SourceListResponse>) {
                    if(response.isSuccessful){
                        response.body()?.apply {
                            success(this)
                        } ?: fail("Error")
                    } else {
                        fail("Error")
                    }
                }

            })

    }


}