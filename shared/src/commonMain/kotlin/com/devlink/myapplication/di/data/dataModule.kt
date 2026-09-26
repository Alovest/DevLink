package com.devlink.myapplication.di.data

import com.devlink.myapplication.data.local.SessionManager
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val dataModule = module {
    single { SessionManager(get()) }
    single {
        HttpClient{
            install(ContentNegotiation){
                json(Json { ignoreUnknownKeys = true })
            }

            val sessionManager = get<SessionManager>()
            install(Auth) {
                bearer {
                    loadTokens {
                        val accessToken = sessionManager.getAccessToken()
                        val refreshToken = sessionManager.getRefreshToken()

                        if (accessToken != null){
                            BearerTokens(accessToken, refreshToken ?: "" )
                        } else {
                            null
                        }
                    }
                }
            }
        }
    }

}