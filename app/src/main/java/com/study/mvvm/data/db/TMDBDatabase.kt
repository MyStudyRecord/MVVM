package com.study.mvvm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.study.mvvm.data.db.ArtistDao
import com.study.mvvm.data.db.MovieDao
import com.study.mvvm.data.db.TvShowDao
import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.movie.Movie
import com.study.mvvm.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class]
, version = 1
, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    //Dao 인터페이스를 얻기 위해 추상 함수를 정의 해야한다고 한다. 왜?
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao

}