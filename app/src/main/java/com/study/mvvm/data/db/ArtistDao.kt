package com.study.mvvm.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.study.mvvm.data.model.artist.Artist
import com.study.mvvm.data.model.movie.Movie

@Dao
interface ArtistDao {
    //이전 데이터를 대체하고 새로운 값을 넣는다
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artist:List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtist():List<Artist>
}