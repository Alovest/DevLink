package com.devlink.myapplication.app.presentation.screens.main_screens.vacancy_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.devlink.myapplication.app.presentation.ui.theme.dimens
import devlink.shared.generated.resources.Res
import devlink.shared.generated.resources.menu_humburger
import devlink.shared.generated.resources.search_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun VacancyScreen(){
    var inputSumethingForSearch by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
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
                .fillMaxWidth()
                .height(56.dp),
            placeholder = {
                Text(
                    text = "Hinted search text",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurface
                ) },
            leadingIcon = {
                IconButton(onClick = {
                    // ЗДЕСЬ НУЖНО ДОБАВИТЬ ФУНКЦИЮ ДЛЯ ОТКРЫТИЯ СПИСКА КАТЕГОРИИ СТЕКОВ!!!
                    TODO()
                }) {
                    Icon(
                        painter = painterResource(Res.drawable.menu_humburger),
                        contentDescription = "Menu humburger of vacancy screen"
                    )
                }
            },
            interactionSource = interactionSource,
            trailingIcon = {
                if (!isFocused || inputSumethingForSearch.isEmpty()) {
                    Icon(
                        painter = painterResource(Res.drawable.search_icon),
                        contentDescription = "search icon"
                    )
                }
            },
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )
        //Text("VACANCY", fontSize = 40.sp)
    }
}

@Composable
@Preview
fun ShowVacancyScreen(){
    VacancyScreen()
}