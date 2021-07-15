package com.study.mvvm.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.study.mvvm.domain.usecase.GetArtistsUseCase
import com.study.mvvm.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel(){
    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists()= liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}