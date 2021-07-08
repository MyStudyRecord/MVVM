package com.study.mvvm.data.repository.movie.datasourceImpl

import com.study.mvvm.data.api.TMDBService
import com.study.mvvm.data.model.movie.MovieList
import com.study.mvvm.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

//MovieRemoteDatasource 인터페이스 구현
class MovieRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val apiKey:String) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {

        return tmdbService.getPopularMovies(apiKey )
    }
}