package com.study.mvvm.data.repository.artist.datasource

import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists:List<Artist>)
    suspend fun clearAll()
}