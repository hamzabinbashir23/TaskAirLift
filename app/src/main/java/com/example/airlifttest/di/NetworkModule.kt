package com.example.airlifttest.di

import com.example.airlifttest.network.BackEndApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    var BASE_URL: String? = "https://fakestoreapi.com/"


    @Provides
    @Singleton
    fun  getRetroServiceInterface(retrofit: Retrofit): BackEndApi {

        return retrofit.create(BackEndApi::class.java)

    }

    @Provides
    @Singleton
    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}