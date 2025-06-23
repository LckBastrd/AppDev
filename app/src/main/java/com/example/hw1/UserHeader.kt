package com.example.hw1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun userHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Biel Morro", color = Color.White, fontSize = 16.sp)

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = {}) {
            Icon(painter = painterResource(R.drawable.download), contentDescription = "Download", tint = Color.White)
        }
        IconButton(onClick = {}) {
            Icon(painter = painterResource(R.drawable.favorite), contentDescription = "Like", tint = Color.White)
        }
        IconButton(onClick = {}) {
            Icon(painter = painterResource(R.drawable.bookmark), contentDescription = "Save", tint = Color.White)
        }
    }
}