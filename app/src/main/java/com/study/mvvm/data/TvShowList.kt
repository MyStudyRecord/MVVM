package com.study.mvvm.data

data class TvShowList(
    val page: Int,
    val tvShows: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)