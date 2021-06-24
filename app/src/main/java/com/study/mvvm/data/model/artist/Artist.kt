package com.study.mvvm.data.model.artist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//기본 클래스 이름말고 다른 이름을 원할경우 Entity(이름)
@Entity(tableName = "popular_artist")
data class Artist(
    @PrimaryKey
    val id: Int,

    //데이터베이스 테이블 열에 다른이름을 지정하려면 ColumnInfo 사용
//    @ColumnInfo(name = "artist_name")
    val name: String,
    val popularity: Double,
    val profile_path: String
)