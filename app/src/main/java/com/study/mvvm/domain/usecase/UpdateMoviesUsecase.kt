package com.study.mvvm.domain.usecase

import com.study.mvvm.data.model.movie.Movie
import com.study.mvvm.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()

}