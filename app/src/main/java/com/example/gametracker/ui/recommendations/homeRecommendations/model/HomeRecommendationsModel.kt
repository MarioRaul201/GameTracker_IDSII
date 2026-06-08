package com.example.gametracker.ui.recommendations.homeRecommendations.model

data class Game(
    val title: String,
    val platform: String,
    val progress: Int,
    val status: String,
    val emoji: String
)

data class GamesResponse(
    val games: List<Game>
)
