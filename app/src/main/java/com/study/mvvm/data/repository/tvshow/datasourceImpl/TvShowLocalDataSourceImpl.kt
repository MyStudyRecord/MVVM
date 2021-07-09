package com.study.mvvm.data.repository.tvshow.datasourceImpl

import com.study.mvvm.data.db.ArtistDao
import com.study.mvvm.data.db.MovieDao
import com.study.mvvm.data.db.TvShowDao
import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.movie.Movie
import com.study.mvvm.data.model.tvshow.TvShow
import com.study.mvvm.data.repository.artist.datasource.ArtistLocalDataSource
import com.study.mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.study.mvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShow()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        tvShowDao.saveTvShow(tvShows)
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShow()
        }
    }
}