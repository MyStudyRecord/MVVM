package com.study.mvvm.presentation.di

import com.study.mvvm.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {

    //앱의 전체 작동 시간 동안 단일 개조 인스턴스를 유지(효율적)
    @Singleton
    @Provides
    //Retrofit 인스턴스
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }


    @Singleton
    @Provides
    //TMDBService 인스턴스
    fun provideTMDBService(retrofit: Retrofit):TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}