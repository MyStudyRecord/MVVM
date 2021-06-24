package com.study.mvvm.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.study.mvvm.data.model.movie.Movie
import com.study.mvvm.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    //이전 데이터를 대체하고 새로운 값을 넣는다
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShow:List<TvShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShow()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTvShow(tvShow:List<TvShow>)
}