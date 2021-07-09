package com.study.mvvm.data.repository.tvshow

import android.util.Log
import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.movie.Movie
import com.study.mvvm.data.model.tvshow.TvShow
import com.study.mvvm.data.repository.artist.datasource.ArtistCacheDataSource
import com.study.mvvm.data.repository.artist.datasource.ArtistLocalDataSource
import com.study.mvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.study.mvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.study.mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.study.mvvm.data.repository.movie.datasource.MovieRemoteDatasource
import com.study.mvvm.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.study.mvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.study.mvvm.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.study.mvvm.domain.repository.ArtistRepository
import com.study.mvvm.domain.repository.MovieRepository
import com.study.mvvm.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)
        return newListOfTvShows
    }


    //API호출해서 값 가져오기
    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            //요청
            val response = tvShowRemoteDatasource.getTvShows()

            //응답 가져오기
            val body = response.body()

            if (body != null) {
                tvShowList = body.tvShows
            }

        } catch (exception: Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    //DB저장된 값 가져오기
    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)

        }
        return tvShowList
    }

    //캐시 가져오기
    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        } catch (exception: Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }


}