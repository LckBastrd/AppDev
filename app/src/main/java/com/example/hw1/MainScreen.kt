package com.example.hw1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.hw1.data.UnsplashPhoto

@Composable
fun MainScreen(state: UiState) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
            }

            state.photo != null -> {
                val photo: UnsplashPhoto = state.photo

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(photo.urls?.regular ?: ""),
                        contentDescription = "Unsplash Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.45f)
                    )

                    UserHeader(
                        userName = photo.user?.name ?: "-",
                        avatarUrl = photo.user?.profile_image?.medium
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        thickness = 0.7.dp,
                        color = Color.LightGray.copy(alpha = 0.3f)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    InfoSection(
                        camera = photo.exif?.model,
                        aperture = photo.exif?.aperture,
                        focalLength = photo.exif?.focal_length,
                        shutterSpeed = photo.exif?.exposure_time,
                        iso = photo.exif?.iso,
                        dimensions = "${photo.width ?: "-"} x ${photo.height ?: "-"}"
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        thickness = 0.5.dp,
                        color = Color.LightGray.copy(alpha = 0.3f)
                    )

                    Spacer(modifier = Modifier.height(1.dp))

                    TagsBar(photo.tags?.mapNotNull { it.title } ?: emptyList())

                    Spacer(modifier = Modifier.height(8.dp))

                    StatsRow(
                        views = photo.views,
                        downloads = photo.downloads,
                        likes = photo.likes
                    )
                }
            }

            else -> {
                Text(
                    text = state.error ?: "Error loading photo",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}