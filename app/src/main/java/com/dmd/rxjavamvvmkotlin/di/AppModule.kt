package com.dmd.rxjavamvvmkotlin.di

import com.dmd.rxjavamvvmkotlin.api.UsersApi
import com.dmd.rxjavamvvmkotlin.constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun providePerPage() = Constants.API_PARAMETER_VALUE

    @Singleton
    @Provides
    fun provideRetrofit(BASE_URL: String): UsersApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsersApi::class.java)
}