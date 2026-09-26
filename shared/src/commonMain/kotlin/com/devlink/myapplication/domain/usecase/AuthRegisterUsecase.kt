package com.devlink.myapplication.domain.usecase

import com.devlink.myapplication.data.model.AuthResponse
import com.devlink.myapplication.domain.repository.AuthRepository

class AuthRegisterUsecase(private val repository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String, email: String): AuthResponse{
      return repository.AuthRegister(username, password, email)
    }
}