package com.example.gametracker.ui.friends.homeFriends.model

data class Friend(
    val name: String,
    val status: String,
    val currentGame: String,
    val gamesCompleted: Int
)

data class HomeFriendsModel(
    val title: String = "👥 Amistades",
    val friends: List<Friend> = listOf(
        Friend("Mario Jiménez", "En línea", "Elden Ring", 12),
        Friend("Sebastián Avitia", "En línea", "Hollow Knight", 8),
        Friend("Admin Epic", "Ausente", "Cyberpunk 2077", 25),
        Friend("Usuario Simple", "Desconectado", "Último juego: Zelda", 3)
    )
)
