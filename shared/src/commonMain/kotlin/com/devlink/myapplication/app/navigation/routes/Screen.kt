package com.devlink.myapplication.app.navigation.routes

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
@Serializable
sealed interface Screen: NavKey {

    // Registration Screens:
    @Serializable
    data object CreateAccount: Screen
    @Serializable
    data object EnterEmail: Screen
    @Serializable
    data object InterestsScreen: Screen

    @Serializable
    data object TechStack: Screen
    @Serializable
    data object Mission: Screen
    @Serializable
    data object EnterVerificationCode: Screen
    @Serializable
    data object Experience: Screen
//
    //Main Screens:
    @Serializable
    data object VacancyScreen: Screen

    @Serializable
    data object ChatScreen: Screen

    @Serializable
    data object LeadProjectScreen: Screen

    @Serializable
    data object ProfileScreen: Screen
    //
}

    val navConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            // Registration Screens:
            subclass(Screen.InterestsScreen::class)
            subclass(Screen.TechStack::class)
            subclass(Screen.Experience::class)
            subclass(Screen.EnterVerificationCode::class)
            subclass(Screen.Mission::class)
            subclass(Screen.EnterEmail::class)
            subclass(Screen.CreateAccount::class)

            // Main Screens:
            subclass(Screen.VacancyScreen::class)
            subclass(Screen.ChatScreen::class)
            subclass(Screen.LeadProjectScreen::class)
            subclass(Screen.ProfileScreen::class)
        }
    }
}