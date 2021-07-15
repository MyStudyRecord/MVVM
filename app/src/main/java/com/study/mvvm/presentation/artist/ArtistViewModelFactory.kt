package com.study.mvvm.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.study.mvvm.domain.usecase.GetArtistsUseCase
import com.study.mvvm.domain.usecase.GetMoviesUseCase
import com.study.mvvm.domain.usecase.UpdateArtistsUseCase
import com.study.mvvm.domain.usecase.UpdateMoviesUseCase
import com.study.mvvm.presentation.movie.MovieViewModel

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}