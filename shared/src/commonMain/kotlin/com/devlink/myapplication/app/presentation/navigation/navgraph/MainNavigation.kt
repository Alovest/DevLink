package com.devlink.myapplication.app.presentation.navigation.navgraph

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntryDecorator
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
import com.devlink.myapplication.app.presentation.uiState.auth.AuthState
import com.devlink.myapplication.app.presentation.viewmodel.auth.AuthRegisterViewModel
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainNavigation() {
    KoinApplication(application = {
        modules(appModules)
    }) {
        val viewModel: AuthRegisterViewModel = koinViewModel()
        var email by remember { mutableStateOf("") }
        val state = viewModel.uiState
        val initialScreen = remember {
            if (state is AuthState.Success) Screen.VacancyScreen else Screen.EnterEmail
        }
        val backStack = rememberNavBackStack(
            navConfig,
            initialScreen
        )

        LaunchedEffect(state) {
            if (state is AuthState.Success) {
                backStack.clear()
                backStack.add(Screen.VacancyScreen)
            }
        }

        var activeRenderedScreen by remember { mutableStateOf<Screen?>(initialScreen) }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                val isBottomBarVisible = activeRenderedScreen is Screen.VacancyScreen ||
                        activeRenderedScreen is Screen.ChatScreen ||
                        activeRenderedScreen is Screen.LeadProjectScreen ||
                        activeRenderedScreen is Screen.ProfileScreen

                if (isBottomBarVisible) {
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
                    // Экраны регистрации:
                    entry<Screen.TechStack> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.TechStack }
                        TechStack(backStack)
                    }
                    entry<Screen.InterestsScreen> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.InterestsScreen }
                        Interests(backStack)
                    }
                    entry<Screen.Mission> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.Mission }
                        Mission(backStack)
                    }
                    entry<Screen.Experience> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.Experience }
                        Experience(backStack)
                    }
                    entry<Screen.CreateAccount> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.CreateAccount }
                        CreateAccount(
                            backStack,
                            onRegisterClick = { username ->
                                viewModel.registerUsername(username)
                            }
                        )
                    }
                    entry<Screen.EnterVerificationCode> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.EnterVerificationCode }
                        EnterVerificationCode(
                            backStack,
                            email
                        )
                    }
                    entry<Screen.EnterEmail> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.EnterEmail }
                        EnterEmail(
                            backStack,
                            viewModel.uiState,
                            onRegisterClick = { password, email ->
                                viewModel.registerPasswordAndEmail(email, password)
                            },
                            email = email,
                            updateEmail = { email = it }
                        )
                    }

                    // Главные экраны:
                    entry<Screen.VacancyScreen> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.VacancyScreen }
                        VacancyScreen()
                    }
                    entry<Screen.ChatScreen> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.ChatScreen }
                        ChatScreen()
                    }
                    entry<Screen.LeadProjectScreen> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.LeadProjectScreen }
                        LeadProjectScreen()
                    }
                    entry<Screen.ProfileScreen> {
                        LaunchedEffect(Unit) { activeRenderedScreen = Screen.ProfileScreen }
                        ProfileScreen()
                    }
                }
            )
        }
    }
}
