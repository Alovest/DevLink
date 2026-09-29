package com.devlink.myapplication.domain.usecase

import com.devlink.myapplication.data.model.AuthResponse
import com.devlink.myapplication.domain.repository.AuthRepository

class AuthRegisterPasswordAndEmailUsecase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): AuthResponse{
      return repository.AuthRegisterPasswordAndEmail( email, password)
    }
}