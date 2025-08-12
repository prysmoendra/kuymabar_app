package com.dakode.kuymabar.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dakode.kuymabar.data.VenueRepository
import com.dakode.kuymabar.model.SportVenue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Definisikan UI State
data class HomeUiState(
    val isLoading: Boolean = true,
    val venues: List<SportVenue> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: VenueRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchVenues()
    }

    private fun fetchVenues() {
        viewModelScope.launch {
            _uiState.value = HomeUiState(isLoading = true)
            try {
                val venueList = repository.getVenues()
                _uiState.value = HomeUiState(venues = venueList, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = HomeUiState(error = e.message, isLoading = false)
            }
        }
    }
}
