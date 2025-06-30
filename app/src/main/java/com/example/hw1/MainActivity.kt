package com.example.hw1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.hw1.data.UnsplashApi
import com.example.hw1.data.UnsplashRepository
import com.example.hw1.ui.theme.Hw1Theme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<PhotoViewModel> {
        val repository = UnsplashRepository(UnsplashApi.apiService)
        object : androidx.lifecycle.ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return PhotoViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sampleId = "JXCrcpROus8"
        viewModel.getPhotoDetails(sampleId)

        setContent {
            Hw1Theme {
                val state by viewModel.uiState.collectAsState()
                MainScreen(state)
            }
        }
    }
}