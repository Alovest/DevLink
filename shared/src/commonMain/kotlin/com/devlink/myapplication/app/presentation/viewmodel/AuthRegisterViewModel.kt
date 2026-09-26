package com.devlink.myapplication.app.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devlink.myapplication.app.presentation.uiState.AuthState
import com.devlink.myapplication.data.local.SessionManager
import com.devlink.myapplication.domain.usecase.AuthRegisterUsecase
import kotlinx.coroutines.launch

class AuthRegisterViewModel(
    private val sessionManager: SessionManager,
    private val usecase: AuthRegisterUsecase
): ViewModel() {
    var uiState by mutableStateOf<AuthState>(AuthState.Idle)
    fun register(username: String, password: String, email: String) {
        viewModelScope.launch {
            uiState = AuthState.Loading
            try {
                val response = usecase(username, password, email)
                sessionManager.saveTokens(response.token, response.token)
                uiState = AuthState.Success
            } catch (e: Exception) {
                uiState = AuthState.Error("Ошибка сети: ${e.message}")
            }
        }
    }
}