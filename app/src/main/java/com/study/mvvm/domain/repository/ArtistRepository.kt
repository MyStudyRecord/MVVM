package com.study.mvvm.domain.repository

import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.tvshow.TvShow

interface ArtistRepository {
    suspend fun getArtists():List<Artist>
    suspend fun updateArtists():List<Artist>

}