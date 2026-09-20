package com.devlink.myapplication.app.screens.main_screens.vacancy_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devlink.myapplication.app.ui.theme.dimens

@Composable
fun VacancyScreen(){
    var inputSumethingForSearch by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(
                horizontal = MaterialTheme.dimens.spaceLarge,
                vertical = MaterialTheme.dimens.spaceMedium
            )
    ) {
        TextField(
            value = inputSumethingForSearch,
            onValueChange = {inputSumethingForSearch = it},
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Hinted search text",
                    color = MaterialTheme.colorScheme.onSurface
                ) },
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            )
        )
        Text("VACANCY", fontSize = 40.sp)
    }
}

@Composable
@Preview
fun ShowVacancyScreen(){
    VacancyScreen()
}