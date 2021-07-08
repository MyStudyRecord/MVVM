package com.study.mvvm.data.repository.artist.datasource

import com.study.mvvm.data.model.artist.ArtistList
import com.study.mvvm.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDatasource {
    //영화목록 반환
    suspend fun getArtists(): Response<ArtistList>
}