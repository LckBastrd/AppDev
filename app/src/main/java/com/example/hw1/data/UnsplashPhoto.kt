package com.example.hw1.data

data class UnsplashPhoto(
    val id: String?,
    val width: Int?,
    val height: Int?,
    val color: String?,
    val likes: Int?,
    val downloads: Int?,
    val views: Int?,
    val user: UnsplashUser?,
    val location: UnsplashLocation?,
    val exif: UnsplashExif?,
    val urls: UnsplashUrls?,
    val tags: List<UnsplashTag>?
)

data class UnsplashUser(
    val name: String?,
    val profile_image: ProfileImage?
)

data class ProfileImage(
    val medium: String?
)

data class UnsplashLocation(
    val name: String?
)

data class UnsplashExif(
    val make: String?,
    val model: String?,
    val exposure_time: String?,
    val aperture: String?,
    val focal_length: String?,
    val iso: Int?
)

data class UnsplashUrls(
    val regular: String?
)

data class UnsplashTag(
    val title: String?
)