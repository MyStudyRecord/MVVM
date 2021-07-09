package com.study.mvvm.data.repository.tvshow.datasource

import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.movie.Movie
import com.study.mvvm.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(tvShows:List<TvShow>)
}