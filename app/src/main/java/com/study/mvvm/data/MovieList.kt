package com.study.mvvm.data

import com.study.mvvm.data.Movie

data class MovieList(
    val page: Int,
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)