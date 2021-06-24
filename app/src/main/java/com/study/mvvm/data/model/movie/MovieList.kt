package com.study.mvvm.data.model.movie

import com.study.mvvm.data.model.movie.Movie

data class MovieList(
    val page: Int,
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)