package com.example.gametracker.ui.progress.homeProgress.model

data class GameProgress(
    val title: String,
    val platform: String,
    val progress: Int,
    val status: String,
    val emoji: String
)

data class HomeProgressModel(
    val title: String = "🎮 Mi Progreso",
    val games: List<GameProgress> = listOf(
        GameProgress("Dying Light: The Beast", "XBOX", 35, "En progreso", "🧟"),
        GameProgress("Mortal Kombat 1", "XBOX", 100, "Completado", "🥊"),
        GameProgress("The Finals", "PC", 78, "En progreso", "🏆"),
        GameProgress("Arc Raiders", "PC", 60, "Pendiente", "🤖"),
        GameProgress("Invincible VS", "XBOX", 40, "En progreso", "💥"),
        GameProgress("Minecraft", "PC", 100, "Completado", "⛏️")
    )
)
