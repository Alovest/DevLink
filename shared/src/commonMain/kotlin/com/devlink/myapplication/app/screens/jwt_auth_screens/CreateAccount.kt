package com.devlink.myapplication.app.screens.jwt_auth_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devlink.myapplication.app.ui.theme.dimens
import devlink.shared.generated.resources.Res
import devlink.shared.generated.resources.add_image
import devlink.shared.generated.resources.arrow_left
import devlink.shared.generated.resources.img
import devlink.shared.generated.resources.plus
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun CreateAccount(){
    var inputUsername by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(horizontal = MaterialTheme.dimens.spaceLarge, vertical = MaterialTheme.dimens.spaceLarge)) {
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
                painter = painterResource(Res.drawable.arrow_left),
                contentDescription = "back",
                modifier = Modifier.size(28.dp),
                colorFilter = ColorFilter
                    .tint(MaterialTheme.colorScheme.onBackground)
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceLarge))
        Text(
            text = "Create your DevLink account",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 20.sp)
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraLarge))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            AvatarPicker(onClick = {
                TODO()
            })
        }
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraLarge))
        Column {
            Text(
                text = "Username",
                color = MaterialTheme.colorScheme.onBackground
            )
            TextField(
                value = inputUsername,
                onValueChange = {inputUsername = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        shape = RoundedCornerShape(8.dp)
                    ),
                placeholder = {
                    Text(
                        text = "Enter your username",
                        color = MaterialTheme.colorScheme.onSurface
                    ) },
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                )
            )
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
                    text = "Last step",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceMedium)) {
                Button(
                    onClick = {
                        TODO()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                    shape = RoundedCornerShape(MaterialTheme.dimens.spaceLarge),
                    modifier = Modifier
                        .width(120.dp)
                        .height(56.dp)
                        .weight(1F)
                )
                {
                    Text(text = "Create account",
                        fontSize = 15.sp,
                        color = Color.White)
                }
            }
        }
    }
}



@Composable
fun AvatarPicker(
    modifier: Modifier = Modifier,
    onClick: () -> Unit){
    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)
    )
    Box(
        modifier = modifier
            .size(150.dp)
            .clip(CircleShape)
            .clickable{ onClick() }
            .drawBehind{
                drawCircle(
                    color = Color.Gray,
                    style = stroke
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(Res.drawable.plus),
            contentDescription = "Add Avatar",
            modifier = modifier.size(48.dp)
        )
    }
}



@Composable
@Preview
fun ShowScreenCreateAccount(){
    CreateAccount()
}