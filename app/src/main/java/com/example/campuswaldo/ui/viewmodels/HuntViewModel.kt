package com.example.campuswaldo.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.campuswaldo.data.model.RedeemResult
import com.example.campuswaldo.data.model.WaldoOfDay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HuntUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val waldo: WaldoOfDay? = null,
    val codeInput: String = "",
    val redeemResult: RedeemResult? = null
)

class HuntViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HuntUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    init {
        loadTodayWaldo()
    }

    private fun loadTodayWaldo() {
        val waldo = WaldoOfDay(
            alias = "Library Waldo",
            imageUrl = " **** URL HERE ****",
            hints = listOf(
                "I am surrounded by books.",
                "It is very quiet here.",
                "You might swipe your student ID to enter."
            )
        )

        _uiState.value = _uiState.value.copy(
            isLoading = false,
            error = null,
            waldo = waldo
        )
    }

    /** Called when the user types in the code field */
    fun updateCodeInput(code: String) {
        _uiState.value = _uiState.value.copy(
            codeInput = code,
            redeemResult = null // clear previous result
        )
    }

    /** Called when the user taps the Redeem button */
    fun redeemCode() {
        val current = _uiState.value
        val code = current.codeInput.trim()
        if (code.isEmpty()) return

        val correct = code.equals("CORNELL", ignoreCase = true)
        val result = RedeemResult(
            correct = correct,
            pointsEarned = if (correct) 18 else 0,
            message = if (correct) "You found today’s Waldo!" else "Wrong code. Keep hunting!"
        )

        _uiState.value = current.copy(
            redeemResult = result,
            error = null
        )
    }
}