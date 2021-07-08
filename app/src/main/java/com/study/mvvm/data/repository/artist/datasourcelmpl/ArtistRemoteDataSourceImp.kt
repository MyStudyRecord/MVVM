package com.study.mvvm.data.repository.artist.datasourcelmpl

import com.study.mvvm.data.api.TMDBService
import com.study.mvvm.data.model.artist.ArtistList
import com.study.mvvm.data.model.movie.MovieList
import com.study.mvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.study.mvvm.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val apiKey:String) : ArtistRemoteDatasource {

    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}