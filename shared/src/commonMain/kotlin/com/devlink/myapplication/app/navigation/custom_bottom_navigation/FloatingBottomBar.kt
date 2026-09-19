package com.devlink.myapplication.app.navigation.custom_bottom_navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.devlink.myapplication.app.navigation.routes.Screen
import com.devlink.myapplication.app.navigation.routes.navConfig
import com.devlink.myapplication.app.ui.theme.dimens
import devlink.shared.generated.resources.Res
import devlink.shared.generated.resources.chat_screen
import devlink.shared.generated.resources.lead_project_screen
import devlink.shared.generated.resources.profile_screen
import devlink.shared.generated.resources.vacancy_screen
import org.jetbrains.compose.resources.painterResource
import kotlin.collections.mutableListOf

@Composable
fun FloatingBottomBar(
    backStack: MutableList<Screen>
) {
    val currentScreen = backStack.lastOrNull()

    Surface(
        modifier = Modifier
            .padding(horizontal = 28.dp, vertical = 24.dp)
            .fillMaxWidth()
            .height(68.dp),
        shape = RoundedCornerShape(34.dp),
        color = Color(0xFF141315)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val items = listOf(
                Screen.VacancyScreen to Res.drawable.vacancy_screen,
                Screen.ChatScreen to Res.drawable.chat_screen,
                Screen.LeadProjectScreen to Res.drawable.lead_project_screen,
                Screen.ProfileScreen to Res.drawable.profile_screen
            )
            items.forEach {
                (screen, iconRes) ->
                val isSelected = currentScreen == screen

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable(interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            if (!isSelected){
                                backStack.clear()
                                backStack.add(screen)
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(iconRes),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = if (isSelected) Color.White else Color.Gray
                        )
                        if (isSelected) {
                            Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceSmall))
                            Box(
                                modifier = Modifier.height(MaterialTheme.dimens.spaceSmall)
                                    .width(MaterialTheme.dimens.spaceLarge)
                                    .background(Color(0xFF8A5CFF), CircleShape)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ShowFloatingBottomBarScreen(){
    val fakeList = remember {
        mutableStateListOf<Screen>(Screen.VacancyScreen)
    }
    FloatingBottomBar(backStack = fakeList)
}