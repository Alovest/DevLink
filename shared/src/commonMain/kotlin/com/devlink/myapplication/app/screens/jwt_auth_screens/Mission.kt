package com.devlink.myapplication.app.screens.jwt_auth_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.devlink.myapplication.app.navigation.routes.Screen
import com.devlink.myapplication.app.ui.theme.dimens
import devlink.shared.generated.resources.Res
import devlink.shared.generated.resources.arrow_left
import devlink.shared.generated.resources.img
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import kotlin.collections.listOf


@Composable
fun Mission(backStack: NavBackStack<NavKey>){
    val options = remember {
        listOf(
            "Grow my network",
            "Find a co-founder",
            "Find a job",
            "Learn & improve my skills",
            "Build my own project",
            "Join a project"
        )
    }
    val selectedOptions = remember { mutableStateSetOf<String>() }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(horizontal = MaterialTheme.dimens.spaceLarge, vertical = MaterialTheme.dimens.spaceLarge)) {
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraLarge))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
                {
                    backStack.add(Screen.EnterVerificationCode)
                }
        ) {
            Image(
                painter = painterResource(Res.drawable.arrow_left),
                contentDescription = "back",
                modifier = Modifier.size(28.dp),
                colorFilter = ColorFilter
                    .tint(MaterialTheme.colorScheme.onBackground)
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceLarge))
        Text(
            text = "What brings you to DevLink?",
             color = MaterialTheme.colorScheme.onBackground,
             fontSize = 20.sp)
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceMedium))
        Text(
            text = "Tell us what you want to achieve. We'll \npersonalize your experience around your goals.",
             fontSize = 15.sp,
             color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceLarge))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMedium),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMedium)
        ) {
            options.forEach { optionText ->
                SelectableChip(
                    text = optionText,
                    isSelected = selectedOptions.contains(optionText),
                    onClick = {
                        if (selectedOptions.contains(optionText)) {
                            selectedOptions.remove(optionText)
                        } else {
                            selectedOptions.add(optionText)
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.weight(1F))
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = MaterialTheme.dimens.spaceLarge
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Step 1 of 5",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMedium)) {
                Button(
                    onClick = {
                        backStack.add(Screen.Experience)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(MaterialTheme.dimens.spaceLarge),
                    enabled = selectedOptions.isNotEmpty(),
                    modifier = Modifier
                        .width(120.dp)
                        .height(56.dp)
                        .weight(1F)
                )
                {
                    Text(text = "Skip",
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onBackground)
                }
                Button(
                    onClick = {
                        backStack.add(Screen.Experience)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(MaterialTheme.dimens.spaceLarge),
                    enabled = selectedOptions.isNotEmpty(),
                    modifier = Modifier
                        .width(120.dp)
                        .height(56.dp)
                        .weight(1F)
                )
                {
                    Text(
                        text = "Continue (${selectedOptions.size})",
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}


@Composable
fun SelectableChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
){
    Surface(
        shape = RoundedCornerShape(MaterialTheme.dimens.spaceMedium),
        color = if(isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background,
        modifier = Modifier.clickable(onClick = onClick).height(48.dp),
        border = if (isSelected) null else BorderStroke(1.dp, Color(0xFF5555550)),
        shadowElevation = 3.dp
    ){
        Row(
            modifier = Modifier
                .padding(
                    horizontal = MaterialTheme.dimens.spaceLarge,
                    vertical = MaterialTheme.dimens.spaceMedium
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium
            )

            if (isSelected){
                Spacer(modifier = Modifier.width(MaterialTheme.dimens.spaceMedium))
                Icon(
                    imageVector = vectorResource(Res.drawable.img),
                    contentDescription = "Selected",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}


@Composable
@Preview
fun ShowScreenMission(){
    val backStack = NavBackStack<NavKey>(Screen.Mission)
    Mission(backStack = backStack)
}