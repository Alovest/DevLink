package com.devlink.myapplication.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devlink.myapplication.app.ui.theme.dimens
import devlink.shared.generated.resources.Res
import devlink.shared.generated.resources.logo
import devlink.shared.generated.resources.vk
import devlink.shared.generated.resources.vkk
import devlink.shared.generated.resources.vkkk
import org.jetbrains.compose.resources.painterResource

@Composable
fun EnterEmail() {
    var inputEmail by remember { mutableStateOf("") }
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground, fontSize = 14.sp)) {
            append("By signing up, you agree to our ")
        }

        pushStringAnnotation(tag = "TERMS", annotation = "...")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary, fontSize = 14.sp, fontWeight = FontWeight.Medium))
        {
            append("Terms of Use ")
        }
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground, fontSize = 14.sp)) {
            append("and ")
        }
        pushStringAnnotation(tag = "PRIVACY", annotation = "...")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary, fontSize = 14.sp, fontWeight = FontWeight.Medium)) {
            append("Privacy Policy")
        }
        pop()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(140.dp))
            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(105.dp)
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceLarge))
            Text(
                text = "Welcome",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceMedium))
            Box(modifier = Modifier.width(280.dp)) {
                Text(
                    text = "Please enter an email address to which you have access.",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.wrapContentSize(),
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraLarge))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = MaterialTheme.dimens.spaceLarge,
                        end = MaterialTheme.dimens.spaceLarge
                    )
            ) {
                Text(
                    text = "Email",
                    color = MaterialTheme.colorScheme.onBackground
                )
                TextField(
                    value = inputEmail,
                    onValueChange = {inputEmail = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            1.dp,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    placeholder = {
                        Text(
                            text = "Enter your Email",
                            color = MaterialTheme.colorScheme.onSurface
                        ) },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceLarge))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                    TODO()
                }) {
                    Text(text = "Begin", fontFamily = FontFamily.Default, fontSize = 15.sp)
                }
                Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraLarge))
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1F),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                    Text(
                        text = "or",
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(
                            horizontal = MaterialTheme.dimens.spaceMedium
                        )
                    )
                    HorizontalDivider(
                        modifier = Modifier.weight(1F),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraLarge))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    onClick = {
                        TODO()
                    },
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.vkkk),
                        contentDescription = "vk logo",
                        modifier = Modifier
                            .size(35.dp)
                            .padding(end = MaterialTheme.dimens.spaceMedium)
                    )
                    Text("Sign In With VK", color = Color.Black)
                }
            }
Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
    Spacer(modifier = Modifier.weight(1F))
    ClickableText(
        text = annotatedString,
        modifier = Modifier.width(300.dp).padding(bottom = 24.dp),
        style = TextStyle(textAlign = TextAlign.Center),
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "TERMS", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    println("Клик по ссылке: ${annotation.item}")
                }
            annotatedString.getStringAnnotations(tag = "PRIVACY", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    println("Клик по ссылке: ${annotation.item}")
                }
        }
    )
}
        }
    }
}

@Composable
@Preview
fun ShowScreen(){
    EnterEmail()
}
