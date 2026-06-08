package com.example.gametracker.ui.login.viewmodel

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val validCredentials = mapOf(
        "MarioJimenez@gmail.com" to "123456789",
        "ADMINEPIC@outlook.com" to "UsuarioTodopoderoso",
        "SebastianAvitia@hotmail.com" to "00990066",
        "usuariosimple@yahoo.com" to "123"
    )

    fun login(email: String, password: String): LoginResult {
        if (email.isBlank() || password.isBlank()) {
            return LoginResult.Error("Por favor ingresa tu correo y contraseña")
        }
        val expectedPassword = validCredentials[email]
        if (expectedPassword == null) {
            return LoginResult.Error("Correo no registrado")
        }
        if (expectedPassword != password) {
            return LoginResult.Error("Contraseña incorrecta")
        }
        return LoginResult.Success
    }
}

sealed class LoginResult {
    object Success : LoginResult()
    data class Error(val message: String) : LoginResult()
}