package com.example.hw1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoSection(
    camera: String?,
    aperture: String?,
    focalLength: String?,
    shutterSpeed: String?,
    iso: Int?,
    dimensions: String?
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
                infoText("Camera", camera)
                infoText("Focal Length", focalLength)
                infoText("ISO", iso?.toString())
            }
            Column(modifier = Modifier.weight(1f)) {
                infoText("Aperture", aperture)
                infoText("Shutter Speed", shutterSpeed)
                infoText("Dimensions", dimensions)
            }
        }
    }
}

@Composable
fun infoText(label: String, value: String?) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(label, color = Color.Gray, fontSize = 12.sp)
        Text(value ?: "-", color = Color.White, fontSize = 14.sp)
    }
}