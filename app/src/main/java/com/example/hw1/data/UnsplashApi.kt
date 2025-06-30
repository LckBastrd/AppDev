package com.example.hw1.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UnsplashApi {
    private const val BASE_URL = "https://api.unsplash.com/"

    val apiService: UnsplashApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UnsplashApiService::class.java)
    }
}