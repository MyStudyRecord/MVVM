package com.study.mvvm.data.repository.artist.datasource

import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}