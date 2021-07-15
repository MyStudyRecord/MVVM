package com.study.mvvm.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.study.mvvm.domain.usecase.GetMoviesUseCase
import com.study.mvvm.domain.usecase.GetTvShowsUseCase
import com.study.mvvm.domain.usecase.UpdateMoviesUseCase
import com.study.mvvm.domain.usecase.UpdateTvShowsUseCase
import com.study.mvvm.presentation.movie.MovieViewModel

class TvShowViewModelFactory(

    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}