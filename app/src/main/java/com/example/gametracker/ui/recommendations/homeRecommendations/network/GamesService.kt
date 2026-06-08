package com.example.gametracker.ui.recommendations.homeRecommendations.network

import com.example.gametracker.ui.recommendations.homeRecommendations.model.GamesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GamesService {
    @GET("thejacksonF/8eaddcbd671699e06b782b6a7996112a/raw/f684ce6814382875d03b96d759c6284a181ade7b/games.json")
    suspend fun getGames(): GamesResponse
}

object GamesRetrofitClient {
    val gamesService: GamesService = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GamesService::class.java)
}
