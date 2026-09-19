package com.devlink.myapplication.app.navigation.routes

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
@Serializable
sealed interface Screen: NavKey {
    @Serializable
    data object InterestsScreen: Screen

    @Serializable
    data object TechStack: Screen

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
            subclass(Screen.InterestsScreen::class)
            subclass(Screen.TechStack::class)
            //Main Screens:
            subclass(Screen.VacancyScreen::class)
            subclass(Screen.ChatScreen::class)
            subclass(Screen.LeadProjectScreen::class)
            subclass(Screen.ProfileScreen::class)
        }
    }
}