package com.example.jetpackcomposevideogamesdemo.presentation.common.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.jetpackcomposevideogamesdemo.presentation.common.theme.EpicWorldTheme

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.testTag("ProgressBar"),
            color = EpicWorldTheme.colors.primary
        )
    }
}