package com.study.mvvm.presentation.di

import com.study.mvvm.data.api.TMDBService
import com.study.mvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.study.mvvm.data.repository.artist.datasourcelmpl.ArtistRemoteDataSourceImp
import com.study.mvvm.data.repository.movie.datasource.MovieRemoteDatasource
import com.study.mvvm.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImp
import com.study.mvvm.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.study.mvvm.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDatasource{
        return MovieRemoteDataSourceImp(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImp(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImp(
            tmdbService, apiKey
        )
    }
}