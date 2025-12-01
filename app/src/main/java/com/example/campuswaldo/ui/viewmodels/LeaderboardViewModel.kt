package com.example.campuswaldo.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.campuswaldo.data.model.LeaderboardEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class LeaderboardUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val entries: List<LeaderboardEntry> = emptyList()
)

class LeaderboardViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LeaderboardUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    init {
        loadLeaderboard()
    }

    private fun loadLeaderboard() {
        val entries = listOf(
            LeaderboardEntry(1, "sn23", 245),
            LeaderboardEntry(2, "campusExplorer", 220),
            LeaderboardEntry(3, "waldoHunter", 205),
            LeaderboardEntry(4, "quietLibraryGuy", 190)
        )

        _uiState.value = _uiState.value.copy(
            isLoading = false,
            error = null,
            entries = entries
        )
    }
}