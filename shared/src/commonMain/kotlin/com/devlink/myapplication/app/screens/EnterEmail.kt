package com.devlink.myapplication.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devlink.myapplication.app.ui.theme.dimens
import devlink.shared.generated.resources.Res
import devlink.shared.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun EnterEmail() {
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
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.spaceExtraLarge))
            Text(
                text = "Welcome",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 24.sp
            )
            Text(text = "Please enter an email address to which you have access", color = MaterialTheme.colorScheme.onSurface, fontSize = 15.sp)
        }
    }
}

@Composable
@Preview
fun ShowScreen(){
    EnterEmail()
}
