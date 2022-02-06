package com.example.jetpackcomposevideogamesdemo.presentation.home.model

sealed class HomeSideEffect {
    data class ShowSnackBar(val message: String, val action: String) : HomeSideEffect()
}
