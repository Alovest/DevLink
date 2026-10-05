package com.devlink.myapplication.app.presentation.uiState.users_choices

sealed class UsersChoicesState {
    data object Idle: UsersChoicesState()
    data object Success: UsersChoicesState()
    data object Loading: UsersChoicesState()
    data class Error(val msgError: String): UsersChoicesState()
}