package com.example.gametracker.ui.profile.homeProfile.model

data class HomeProfileModel(
    val avatar: String = "🧟",
    val name: String = "Sebastián Avitia",
    val email: String = "SebastianAvitia@hotmail.com",
    val bio: String = "Yo soy un gamer desde los 9 años. Me encantan los juegos intensos, de zombies, de mundo abierto y con mucha libertad oh yeah",
    val stats: List<Pair<String, String>> = listOf(
        "🎮 Juego favorito" to "Dying Light: The Beast",
        "🖥️ Plataforma favorita" to "PC",
        "⏱️ Juego con más horas" to "Red Dead Redemption 2",
        "🕐 Total de horas jugadas" to "1400 horas"
    )
)
