package com.example.hw1.data

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface UnsplashApiService {
    @Headers("Authorization: Client-ID BsG5xLNr4qw2q1Y_swwt3-KT8jUKwk9vIneSDEjxBUA")
    @GET("photos/{id}")
    suspend fun getPhotoById(@Path("id") id: String): UnsplashPhoto
}