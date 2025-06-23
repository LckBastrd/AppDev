package com.example.hw1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun infoSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
                infoText("Camera", "NIKON D3200")
                infoText("Focal Length", "18.0mm")
                infoText("ISO", "100")
            }
            Column(modifier = Modifier.weight(1f)) {
                infoText("Aperture", "f/5.0")
                infoText("Shutter Speed", "1/125s")
                infoText("Dimensions", "3906 × 4882")
            }
        }
    }
}

@Composable
fun infoText(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(bottom = 8.dp)) {
        Text(label, color = Color.Gray, fontSize = 12.sp)
        Text(value, color = Color.White, fontSize = 14.sp)
    }
}