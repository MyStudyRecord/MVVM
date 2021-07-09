package com.study.mvvm.data.repository.tvshow.datasourceImpl

import com.study.mvvm.data.api.TMDBService
import com.study.mvvm.data.model.artist.ArtistList
import com.study.mvvm.data.model.movie.MovieList
import com.study.mvvm.data.model.tvshow.TvShowList
import com.study.mvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.study.mvvm.data.repository.movie.datasource.MovieRemoteDatasource
import com.study.mvvm.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val apiKey:String) : TvShowRemoteDatasource {

    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}