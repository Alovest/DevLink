package com.devlink.myapplication.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devlink.myapplication.app.ui.theme.dimens
import devlink.shared.generated.resources.Res
import devlink.shared.generated.resources.arrow_back
import org.jetbrains.compose.resources.painterResource
import kotlin.collections.listOf

@Composable
fun Mission(){
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
        .padding(start = MaterialTheme.dimens.spaceLarge)) {
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraLarge))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(48.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
                {
                    TODO()
                }
        ) {
            Image(
                painter = painterResource(Res.drawable.arrow_back),
                contentDescription = "back",
                modifier = Modifier.size(28.dp),
                colorFilter = ColorFilter
                    .tint(MaterialTheme.colorScheme.onBackground)
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceLarge))
        Text(text = "What brings you to DevLink?",
             color = MaterialTheme.colorScheme.onBackground,
             fontSize = 20.sp)
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceMedium))
        Text(text = "Tell us what you want to achieve. We'll \npersonalize your experience around your goals.",
             fontSize = 15.sp,
             color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceLarge))
        FlowRow(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMedium),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMedium)
        ) {
            options.forEach { optionText ->

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
        color = if(isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
    ) {

    }
}


@Composable
@Preview
fun ShowScreenMission(){
    Mission()
}