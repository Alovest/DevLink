package com.devlink.myapplication.data.repository

import com.devlink.myapplication.data.model.AuthResponse
import com.devlink.myapplication.data.model.RegisterRequest
import com.devlink.myapplication.domain.repository.AuthRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthRepositoryImpl(private val client: HttpClient): AuthRepository {
    override suspend fun AuthRegister(username: String, password: String, email: String): AuthResponse {
    return client.post("http://127.0.0.1:8080/user/register") {
            contentType(ContentType.Application.Json)
            setBody(RegisterRequest(username, email, password))
        }.body()
    }
}