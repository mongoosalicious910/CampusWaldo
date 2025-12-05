package com.example.campuswaldo.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class CodeStatus {
    NONE,
    SUCCESS,
    ERROR
}

data class CodeUiState(
    val enteredCode: String = "",
    val status: CodeStatus = CodeStatus.NONE
)

class CodeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CodeUiState())
    val uiState = _uiState.asStateFlow()

    fun updateEnteredCode(code: String) {
        _uiState.value = _uiState.value.copy(
            enteredCode = code,
            status = CodeStatus.NONE // reset status as user types
        )
    }

    fun submitCode() {
        val correctCode = "CORNELL" // temporary until backend integration
        val isCorrect = _uiState.value.enteredCode.trim().equals(correctCode, ignoreCase = true)

        _uiState.value = _uiState.value.copy(
            status = if (isCorrect) CodeStatus.SUCCESS else CodeStatus.ERROR
        )
    }
}
