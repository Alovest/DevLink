package com.devlink.myapplication.domain.usecase.auth

import com.devlink.myapplication.data.model.auth.AuthResponse
import com.devlink.myapplication.domain.repository.auth.AuthRepository

class AuthRegisterPasswordAndEmailUsecase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): AuthResponse {
      return repository.AuthRegisterPasswordAndEmail( email, password)
    }
}