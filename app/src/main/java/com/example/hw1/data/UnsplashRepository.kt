package com.example.hw1.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UnsplashRepository(private val apiService: UnsplashApiService) {
    suspend fun getPhoto(photoId: String): UnsplashPhoto? {
        return withContext(Dispatchers.IO) {
            try {
                apiService.getPhotoById(photoId)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}