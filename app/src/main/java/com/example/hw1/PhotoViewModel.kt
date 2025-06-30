package com.example.hw1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw1.data.UnsplashPhoto
import com.example.hw1.data.UnsplashRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class UiState(
    val isLoading: Boolean = true,
    val photo: UnsplashPhoto? = null,
    val error: String? = null
)

class PhotoViewModel(
    private val repository: UnsplashRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun getPhotoDetails(photoId: String) {
        _uiState.value = UiState(isLoading = true)

        viewModelScope.launch {
            try {
                val result = repository.getPhoto(photoId)
                if (result != null) {
                    _uiState.value = UiState(
                        isLoading = false,
                        photo = result
                    )
                } else {
                    _uiState.value = UiState(
                        isLoading = false,
                        error = "Failed to load photo"
                    )
                }
            } catch (e: Exception) {
                _uiState.value = UiState(
                    isLoading = false,
                    error = "Error: ${e.message}"
                )
            }
        }
    }
}