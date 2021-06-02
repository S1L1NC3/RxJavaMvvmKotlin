package com.dmd.rxjavamvvmkotlin.di

import com.dmd.rxjavamvvmkotlin.constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideBaseUrl() = Constants.BASE_URL
}