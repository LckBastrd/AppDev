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
fun TagsBar(tags: List<String>?) {
    Row(modifier = Modifier.padding(16.dp)) {
        tags?.take(2)?.forEachIndexed { index, tag ->
            TagChip(tag)
            if (index != 1) Spacer(modifier = Modifier.width(8.dp))
        } ?: run {
            TagChip("-")
        }
    }
}

@Composable
fun TagChip(text: String) {
    Box(
        modifier = Modifier
            .background(Color.DarkGray, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(text, color = Color.White, fontSize = 12.sp)
    }
}

@Composable
fun StatsRow(views: Int?, downloads: Int?, likes: Int?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("Views", color = Color.Gray, fontSize = 12.sp)
            Text(views?.toString() ?: "-", color = Color.White)
        }
        Column {
            Text("Downloads", color = Color.Gray, fontSize = 12.sp)
            Text(downloads?.toString() ?: "-", color = Color.White)
        }
        Column {
            Text("Likes", color = Color.Gray, fontSize = 12.sp)
            Text(likes?.toString() ?: "-", color = Color.White)
        }
    }
}