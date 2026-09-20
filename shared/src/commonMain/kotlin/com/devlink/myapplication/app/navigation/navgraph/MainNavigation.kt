package com.devlink.myapplication.app.navigation.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.devlink.myapplication.app.navigation.custom_bottom_navigation.FloatingBottomBar
import com.devlink.myapplication.app.navigation.routes.Screen
import com.devlink.myapplication.app.navigation.routes.navConfig
import com.devlink.myapplication.app.screens.main_screens.chat_screen.ChatScreen
import com.devlink.myapplication.app.screens.main_screens.vacancy_screen.VacancyScreen
import com.devlink.myapplication.app.screens.main_screens.profile_screen.ProfileScreen
import com.devlink.myapplication.app.screens.main_screens.tasks_project_screen.LeadProjectScreen

@Composable
fun MainNavigation() {
    val backStack = rememberNavBackStack(
        navConfig,
        Screen.VacancyScreen
        )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            FloatingBottomBar(backStack = backStack)
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            modifier = Modifier.padding(innerPadding),
            onBack = {
                if (backStack.size > 1){
                    backStack.removeLastOrNull()
                }
            },
            entryProvider = entryProvider {
                entry<Screen.VacancyScreen> {
                    VacancyScreen()
                }

                entry<Screen.ChatScreen> {
                    ChatScreen()
                }

                entry<Screen.LeadProjectScreen> {
                    LeadProjectScreen()
                }

                entry<Screen.ProfileScreen> {
                    ProfileScreen()
                }

            }
        )

    }
}