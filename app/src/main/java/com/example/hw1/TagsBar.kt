package com.example.hw1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun tagsBar() {
    Row(modifier = Modifier.padding(16.dp)) {
        tagChip("barcelona")
        Spacer(modifier = Modifier.width(8.dp))
        tagChip("spain")
    }
}

@Composable
fun tagChip(text: String) {
    Box(
        modifier = Modifier
            .background(Color.DarkGray, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(text, color = Color.White, fontSize = 12.sp)
    }
}

@Composable
fun StatsRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("Views", color = Color.Gray, fontSize = 12.sp)
            Text("8.8M", color = Color.White)
        }
        Column {
            Text("Downloads", color = Color.Gray, fontSize = 12.sp)
            Text("99.1K", color = Color.White)
        }
        Column {
            Text("Likes", color = Color.Gray, fontSize = 12.sp)
            Text("1.8K", color = Color.White)
        }
    }
}