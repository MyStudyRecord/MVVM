package com.study.mvvm.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.study.mvvm.domain.usecase.GetMoviesUseCase
import com.study.mvvm.domain.usecase.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUsecase: UpdateMoviesUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase,updateMoviesUsecase) as T
    }
}