package com.study.mvvm.domain.usecase

import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}