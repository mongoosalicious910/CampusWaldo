package com.example.campuswaldo.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.campuswaldo.data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class UserRole {
    WALDO,
    HUNTER
}

data class AppUiState(
    val user: User,
    val role: UserRole
)

class UserViewModel : ViewModel() {

    // Change isTodayWaldo to true to preview the Waldo-only flow
    private val initialUser = User(
        username = "sean23",
        isTodayWaldo = false
    )

    private val _appUiState = MutableStateFlow(
        AppUiState(
            user = initialUser,
            role = if (initialUser.isTodayWaldo) UserRole.WALDO else UserRole.HUNTER
        )
    )
    val appUiState = _appUiState.asStateFlow()
}