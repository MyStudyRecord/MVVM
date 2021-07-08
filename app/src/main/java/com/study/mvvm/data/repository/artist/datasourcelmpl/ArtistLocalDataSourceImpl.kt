package com.study.mvvm.data.repository.artist.datasourcelmpl

import com.study.mvvm.data.db.ArtistDao
import com.study.mvvm.data.db.MovieDao
import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.movie.Movie
import com.study.mvvm.data.repository.artist.datasource.ArtistLocalDataSource
import com.study.mvvm.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtist()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        artistDao.saveArtist(artists)
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}