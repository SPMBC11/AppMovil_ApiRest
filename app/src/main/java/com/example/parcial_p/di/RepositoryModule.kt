package com.example.parcial_p.di

import com.example.parcial_p.data.remote.datasource.HeroRemoteDataSource
import com.example.parcial_p.data.remote.datasource.HeroRemoteDataSourceImpl
import com.example.parcial_p.data.repository.HeroRepository
import com.example.parcial_p.data.repository.HeroRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindHeroRemoteDataSource(impl: HeroRemoteDataSourceImpl): HeroRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindHeroRepository(impl: HeroRepositoryImpl): HeroRepository
}