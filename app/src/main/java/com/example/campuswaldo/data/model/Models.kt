package com.example.campuswaldo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class WaldoOfDay(
    val alias: String,
    val imageUrl: String,
    val hints: List<String>
)

@Serializable
data class LeaderboardEntry(
    val rank: Int,
    val username: String,
    val points: Int
)

data class User(
    val username: String,
    val isTodayWaldo: Boolean
)

data class RedeemResult(
    val correct: Boolean,
    val pointsEarned: Int,
    val message: String
)