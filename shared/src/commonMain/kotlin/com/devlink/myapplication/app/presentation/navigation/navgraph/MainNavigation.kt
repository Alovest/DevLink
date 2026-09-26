package com.devlink.myapplication.app.presentation.navigation.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.devlink.myapplication.app.di.appModules
import com.devlink.myapplication.app.presentation.navigation.custom_bottom_navigation.FloatingBottomBar
import com.devlink.myapplication.app.presentation.navigation.routes.Screen
import com.devlink.myapplication.app.presentation.navigation.routes.navConfig
import com.devlink.myapplication.app.presentation.screens.jwt_auth_screens.CreateAccount
import com.devlink.myapplication.app.presentation.screens.jwt_auth_screens.EnterEmail
import com.devlink.myapplication.app.presentation.screens.jwt_auth_screens.EnterVerificationCode
import com.devlink.myapplication.app.presentation.screens.jwt_auth_screens.Experience
import com.devlink.myapplication.app.presentation.screens.jwt_auth_screens.Interests
import com.devlink.myapplication.app.presentation.screens.jwt_auth_screens.Mission
import com.devlink.myapplication.app.presentation.screens.jwt_auth_screens.TechStack
import com.devlink.myapplication.app.presentation.screens.main_screens.chat_screen.ChatScreen
import com.devlink.myapplication.app.presentation.screens.main_screens.vacancy_screen.VacancyScreen
import com.devlink.myapplication.app.presentation.screens.main_screens.profile_screen.ProfileScreen
import com.devlink.myapplication.app.presentation.screens.main_screens.tasks_project_screen.LeadProjectScreen
import org.koin.compose.KoinApplication

@Composable
fun MainNavigation() {
    KoinApplication(application = {
        modules(appModules)
    }) {
        val backStack = rememberNavBackStack(
            navConfig,
            Screen.EnterEmail
        )

        val currentScreen = backStack.lastOrNull()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { if (currentScreen is Screen.VacancyScreen ||
                currentScreen is Screen.ChatScreen || currentScreen is Screen.LeadProjectScreen || currentScreen is Screen.ProfileScreen) {
                FloatingBottomBar(backStack = backStack)
            }
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            NavDisplay(
                backStack = backStack,
                modifier = Modifier.padding(innerPadding),
                onBack = {
                    if (backStack.size > 1) {
                        backStack.removeLastOrNull()
                    }
                },
                entryProvider = entryProvider {
                    //Registers Screens:
                    entry<Screen.TechStack> {
                        TechStack(backStack)
                    }
                    entry<Screen.InterestsScreen> {
                        Interests(backStack)
                    }
                    entry<Screen.Mission> {
                        Mission(backStack)
                    }
                    entry<Screen.Experience> {
                        Experience(backStack)
                    }
                    entry<Screen.CreateAccount> {
                        CreateAccount(backStack)
                    }
                    entry<Screen.EnterVerificationCode> {
                        EnterVerificationCode(backStack)
                    }
                    entry<Screen.EnterEmail> {
                        EnterEmail(backStack)
                    }
                    //

                    // Main Screens:
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
                    //
                }
            )

        }
    }
}