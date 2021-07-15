package com.study.mvvm.domain.usecase

import com.study.mvvm.data.model.tvshow.TvShow
import com.study.mvvm.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository : TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}