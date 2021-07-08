package com.study.mvvm.data.repository.movie.datasource

import com.study.mvvm.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    //영화목록 반환
    suspend fun getMovies(): Response<MovieList>
}