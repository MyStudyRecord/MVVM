package com.study.mvvm.data.repository.artist

import android.util.Log
import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.movie.Movie
import com.study.mvvm.data.repository.artist.datasource.ArtistCacheDataSource
import com.study.mvvm.data.repository.artist.datasource.ArtistLocalDataSource
import com.study.mvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.study.mvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.study.mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.study.mvvm.data.repository.movie.datasource.MovieRemoteDatasource
import com.study.mvvm.domain.repository.ArtistRepository
import com.study.mvvm.domain.repository.MovieRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }


    //API호출해서 값 가져오기
    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var movieList: List<Artist>
        try {
            //요청
            val response = artistRemoteDatasource.getArtists()

            //응답 가져오기
            val body = response.body()

            if (body != null) {
                movieList = body.artists
            }

        } catch (exception: Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        return movieList
    }

    //DB저장된 값 가져오기
    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)

        }
        return artistList
    }

    //캐시 가져오기
    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }


}