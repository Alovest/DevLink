package com.devlink.myapplication.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devlink.myapplication.app.ui.theme.dimens
import devlink.shared.generated.resources.Res
import devlink.shared.generated.resources.compose_multiplatform
import devlink.shared.generated.resources.logo
import org.jetbrains.compose.resources.painterResource
import kotlin.js.JsExport

@Composable
fun SplashScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,

                ) {
                    Image(
                        painter = painterResource(Res.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(105.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = MaterialTheme.dimens.spaceExtraNahuyEptaEbatLarge,
                            bottom = MaterialTheme.dimens.spaceExtraLarge
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "DevLink",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }

@Composable
@Preview
fun ShowContent(){
    SplashScreen()
}