package com.devlink.myapplication.app.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devlink.myapplication.app.presentation.uiState.AuthState
import com.devlink.myapplication.data.local.SessionManager
import com.devlink.myapplication.domain.usecase.AuthRegisterPasswordAndEmailUsecase
import com.devlink.myapplication.domain.usecase.AuthRegisterUsernameUsecase
import kotlinx.coroutines.launch

class AuthRegisterViewModel(
    private val sessionManager: SessionManager,
    private val usecaseOfPasswordAndEmail: AuthRegisterPasswordAndEmailUsecase,
    private val usecaseOfUsername: AuthRegisterUsernameUsecase
): ViewModel() {
    var uiState by mutableStateOf<AuthState>(AuthState.Idle)
    fun registerPasswordAndEmail(password: String, email: String) {
        viewModelScope.launch {
            uiState = AuthState.Loading
            try {
                val response = usecaseOfPasswordAndEmail(email, password)
                uiState = AuthState.Success
            } catch (e: Exception) {
                uiState = AuthState.Error("Ошибка сети: ${e.message}")
            }
        }
    }

    fun registerUsername(username: String) {
        viewModelScope.launch {
            uiState = AuthState.Loading
            try {
                val response = usecaseOfUsername(username)
                sessionManager.saveTokens(response.accessToken, response.refreshToken)
                uiState = AuthState.Success
            } catch (e: Exception) {
                uiState = AuthState.Error("Ошибка сети: ${e.message}")
            }
        }
    }
}