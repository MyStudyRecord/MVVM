package com.study.mvvm.data.repository.tvshow.datasourceImpl

import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.tvshow.TvShow
import com.study.mvvm.data.repository.artist.datasource.ArtistCacheDataSource
import com.study.mvvm.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)     }
}