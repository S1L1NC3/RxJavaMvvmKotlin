package com.dmd.rxjavamvvmkotlin.di

import com.dmd.rxjavamvvmkotlin.api.UsersApi
import com.dmd.rxjavamvvmkotlin.constants.Constants
import com.dmd.rxjavamvvmkotlin.util.ImageUtil
import com.dmd.rxjavamvvmkotlin.util.IntentUtil
import com.dmd.rxjavamvvmkotlin.util.NetworkUtil
import com.dmd.rxjavamvvmkotlin.util.PreferencesUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule { //Instead of creating instance every time of an class, we created Singleton and it is much better for memory management
    @Singleton
    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    @Named("pageCount")
    fun providePageCount() = Constants.API_PARAMETER_VALUE

    @Singleton
    @Provides
    fun provideNetworkUtil() = NetworkUtil()

    @Singleton
    @Provides
    fun provideImageUtil() = ImageUtil()

    @Singleton
    @Provides
    fun provideIntentUtil() = IntentUtil()

    @Singleton
    @Provides
    fun providePreferencesUtil() = PreferencesUtil()

    @Singleton
    @Provides
    fun provideRetrofit(BASE_URL: String): UsersApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(UsersApi::class.java)
}