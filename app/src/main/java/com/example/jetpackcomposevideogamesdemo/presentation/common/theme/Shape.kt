package com.example.jetpackcomposevideogamesdemo.presentation.common.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import javax.annotation.concurrent.Immutable

@Immutable
data class JCVGDShapes(
    val smallRoundCornerShape: Shape,
    val mediumRoundCornerShape: Shape,
    val largeRoundCornerShape: Shape,
)

val LocalJCVGDShapes = staticCompositionLocalOf {
    JCVGDShapes(
        smallRoundCornerShape = RoundedCornerShape(ZeroCornerSize),
        mediumRoundCornerShape = RoundedCornerShape(ZeroCornerSize),
        largeRoundCornerShape = RoundedCornerShape(ZeroCornerSize)
    )
}