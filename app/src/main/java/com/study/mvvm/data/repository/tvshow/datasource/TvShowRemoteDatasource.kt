package com.study.mvvm.data.repository.tvshow.datasource

import com.study.mvvm.data.model.artist.ArtistList
import com.study.mvvm.data.model.movie.MovieList
import com.study.mvvm.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    //영화목록 반환
    suspend fun getTvShows(): Response<TvShowList>
}