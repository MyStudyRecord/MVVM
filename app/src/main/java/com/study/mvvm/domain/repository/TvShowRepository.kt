package com.study.mvvm.domain.repository

import com.study.mvvm.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>
    suspend fun updateTvShows():List<TvShow>
}