package com.devlink.myapplication.data.local

import com.russhwolf.settings.Settings

class SessionManager(private val settings: Settings) {
    companion object {
        private val KEY_ACCESS_TOKEN = "access token"
        private val KEY_REFRESH_TOKEN = "refresh token"
    }

    fun saveTokens(accessToken: String, refreshToken: String){
        settings.putString(KEY_ACCESS_TOKEN, accessToken)
        settings.putString(KEY_REFRESH_TOKEN, refreshToken)
    }

    fun getAccessToken(): String?{
        return settings.getStringOrNull(KEY_ACCESS_TOKEN)
    }

    fun getRefreshToken(): String?{
        return settings.getStringOrNull(KEY_REFRESH_TOKEN)
    }

    fun clearSession(){
        settings.remove(KEY_ACCESS_TOKEN)
        settings.remove(KEY_REFRESH_TOKEN)
    }

    fun isAuthorized(): Boolean =
        getAccessToken() != null
}