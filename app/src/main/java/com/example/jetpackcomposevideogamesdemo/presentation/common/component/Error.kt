package com.example.jetpackcomposevideogamesdemo.presentation.common.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposevideogamesdemo.presentation.common.theme.EpicWorldTheme
import com.example.jetpackcomposevideogamesdemo.R

@Composable
fun GetGamesError(buttonClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(id = R.string.home_screen_error_message),
            textAlign = TextAlign.Center,
            color = EpicWorldTheme.colors.background,
            style = EpicWorldTheme.typography.body1
        )
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = buttonClick
        ) {
            Text(
                text = stringResource(id = R.string.home_screen_retry),
                style = EpicWorldTheme.typography.button
            )
        }
    }
}