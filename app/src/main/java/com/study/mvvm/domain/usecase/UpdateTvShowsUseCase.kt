package com.study.mvvm.domain.usecase

import com.study.mvvm.data.model.tvshow.TvShow
import com.study.mvvm.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository : TvShowRepository) {
    suspend fun excute(): List<TvShow>? = tvShowRepository.updateTvShows()

}