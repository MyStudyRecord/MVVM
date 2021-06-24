package com.study.mvvm.data.model.tvshow

import com.study.mvvm.data.model.tvshow.TvShow

data class TvShowList(
    val page: Int,
    val tvShows: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)