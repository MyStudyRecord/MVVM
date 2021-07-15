package com.study.mvvm.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.study.mvvm.domain.usecase.GetMoviesUseCase
import com.study.mvvm.domain.usecase.GetTvShowsUseCase
import com.study.mvvm.domain.usecase.UpdateMoviesUseCase
import com.study.mvvm.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel (
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel(){
    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows()= liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}