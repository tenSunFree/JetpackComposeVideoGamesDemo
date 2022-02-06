package com.example.jetpackcomposevideogamesdemo.presentation.common.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.jetpackcomposevideogamesdemo.R
import javax.annotation.concurrent.Immutable

val PlayFair = FontFamily(
    Font(R.font.playfair_display_regular, FontWeight.Normal),
    Font(R.font.playfair_display_bold, FontWeight.Bold),
    Font(R.font.playfair_display_italic, FontWeight.Medium)
)

@Immutable
data class JCVGDTypography(
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val subTitle1: TextStyle,
    val subTitle2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val button: TextStyle
)

val LocalJCVGDTypography = staticCompositionLocalOf {
    JCVGDTypography(
        title1 = TextStyle.Default,
        title2 = TextStyle.Default,
        title3 = TextStyle.Default,
        subTitle1 = TextStyle.Default,
        subTitle2 = TextStyle.Default,
        body1 = TextStyle.Default,
        body2 = TextStyle.Default,
        button = TextStyle.Default
    )
}