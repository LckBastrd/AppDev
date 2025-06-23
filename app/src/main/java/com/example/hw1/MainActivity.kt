package com.example.hw1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw1.ui.theme.Hw1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hw1Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.cathedral),
            contentDescription = "Barcelona",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight(0.45f)
                .fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 180.dp, start = 16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "Pin",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Barcelona, Spain", color = Color.White)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 220.dp)
                .background(Color.Black)
        ) {
            userHeader()

            // Линия 1
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 0.7.dp,
                color = Color.Gray.copy(alpha = 0.3f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            infoSection()

            // Линия 2
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 0.5.dp,
                color = Color.Gray.copy(alpha = 0.3f)
            )

            Spacer(modifier = Modifier.height(7.dp))

            StatsRow()

            // Линия 3
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 0.5.dp,
                color = Color.Gray.copy(alpha = 0.3f)
            )

            Spacer(modifier = Modifier.height(1.dp))

            tagsBar()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    Hw1Theme {
        MainScreen()
    }
}