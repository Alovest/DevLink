package com.devlink.myapplication.data.local

import com.russhwolf.settings.Settings

class SessionManager(private val settings: Settings) {
    companion object {
        private const val KEY_TOKEN = "auth_token"
    }

    fun saveToken(token: String){
        settings.putString(KEY_TOKEN, token)
    }

    fun getToken() {
        settings.getStringOrNull(KEY_TOKEN)
    }

    fun clearSession(){
        settings.remove(KEY_TOKEN)
    }

    fun isAuthorized(): Boolean = getToken() != null
}