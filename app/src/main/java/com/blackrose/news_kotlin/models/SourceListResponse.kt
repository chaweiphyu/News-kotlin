package com.blackrose.news_kotlin.models

data class SourceListResponse(
    val sources: List<SourceList>,
    val status: String
)