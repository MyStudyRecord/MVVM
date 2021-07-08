package com.study.mvvm.data.repository.movie

import android.util.Log
import com.study.mvvm.data.model.movie.Movie
import com.study.mvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.study.mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.study.mvvm.data.repository.movie.datasource.MovieRemoteDatasource
import com.study.mvvm.domain.repository.MovieRepository
import java.lang.Exception

//이 클래스는 MovieRepository 구현
class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }


    //API호출해서 값 가져오기
    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            //요청
            val response = movieRemoteDatasource.getMovies()

            //응답 가져오기
            val body = response.body()

            if (body != null) {
                movieList = body.movies
            }

        } catch (exception: Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        return movieList
    }

    //DB저장된 값 가져오기
    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)

        }
        return movieList
    }

    //캐시 가져오기
    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}