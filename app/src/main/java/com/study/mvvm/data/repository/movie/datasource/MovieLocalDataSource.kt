package com.study.mvvm.data.repository.movie.datasource

import com.study.mvvm.data.model.movie.Movie

interface MovieLocalDataSource {
    //데이터베이스에서 영화 인스턴스 목록을 가져오기
    suspend fun getMoviesFromDB():List<Movie>
    //영화 인스턴스 목록을 데잍베이스에 저장
    suspend fun saveMoviesToDB(movies:List<Movie>)
    //데이터베이스 테이블의 데이터 지우기
    suspend fun clearAll()
}