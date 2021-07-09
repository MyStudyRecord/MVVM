package com.study.mvvm.data.repository.tvshow.datasource

import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.movie.Movie
import com.study.mvvm.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
    suspend fun clearAll()
}