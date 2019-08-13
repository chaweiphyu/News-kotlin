package com.blackrose.news_kotlin.models

data class NewsVO(
    val status: String,
    val totalResults: Int,
    val articles: MutableList<Article>
)

data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

data class Source(
    val id: String,
    val name: String
)