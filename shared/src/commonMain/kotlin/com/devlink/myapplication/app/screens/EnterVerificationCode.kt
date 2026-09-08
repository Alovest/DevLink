package com.devlink.myapplication.app.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devlink.myapplication.app.ui.theme.dimens
import devlink.shared.generated.resources.Res
import devlink.shared.generated.resources.arrow_back
import devlink.shared.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun EnterVerificationCode(){
    val inputEmail by remember { mutableStateOf("soxxxxxx1@gmail.com") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraLarge))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(48.dp)
                .padding(start = MaterialTheme.dimens.spaceLarge)
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
                    .tint(Color.Black)
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraNahuyLarge))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.Center) {
            Text(
                text = "Verification code",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceMedium))
        Row(modifier = Modifier.fillMaxWidth().padding(start = MaterialTheme.dimens.spaceExtraLarge, end = MaterialTheme.dimens.spaceExtraLarge )) {
            Text(
                text = "Please check your email ${inputEmail} (don't forget the spam folder) and enter the code we just sent you.",
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraLarge))
        var otpValue by remember { mutableStateOf("111111") }
        OtpTextField(
            otpText = otpValue,
            otpLenght = 6,
            onOtpTextChange = {
                otpValue = it
            }
        )
    }
}

@Composable
fun OtpCell(
    char: Char?,
    isFocused: Boolean,
    modifier: Modifier = Modifier
){
    val borderColor = if (isFocused) MaterialTheme.colorScheme.primary else Color.LightGray
    val borderWidht = if (isFocused) 2.dp else 1.dp
    val shape = RoundedCornerShape(8.dp)

    Box(
        modifier = modifier.size(50.dp).border(width = borderWidht, color = borderColor, shape = shape)
            .background(MaterialTheme.colorScheme.background, shape = shape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = char?.toString() ?: "",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black
        )
    }
}

@Composable
fun OtpTextField(
    modifier: Modifier = Modifier,
    otpText: String,
    otpLenght: Int = 6,
    onOtpTextChange: (String) -> Unit
){
    val focusRequester = remember { FocusRequester() }
    val selection = TextRange(otpText.length)
    BasicTextField(
        value = TextFieldValue(text = otpText, selection = selection),
        onValueChange = {
            if (it.text.length <= otpLenght) {
                val newText = it.text.filter { char -> char.isDigit() }
                if (newText != otpText) {
                    onOtpTextChange(newText)
                }
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        modifier = modifier
            .size(0.dp)
            .focusRequester(focusRequester),
        decorationBox = { }
    )
    LaunchedEffect(Unit){
        focusRequester.requestFocus()
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        Arrangement.Center
        ){
        repeat(otpLenght){ index ->
            val char = otpText.getOrNull(index)
            val isFocused = otpText.length == index

            OtpCell(
                char = char,
                isFocused = isFocused,
                modifier = modifier.clickable{
                    focusRequester.requestFocus()
                }
            )
            if (index < otpLenght - 1){
                Spacer(modifier = modifier.width(8.dp))
            }
        }
    }
}

@Composable
@Preview
fun ShowScreenEnterVerificationCode(){
    EnterVerificationCode()
}