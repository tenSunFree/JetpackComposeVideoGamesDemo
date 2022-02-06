package com.example.jetpackcomposevideogamesdemo.presentation.common.base

sealed class ScreenState {
    object Loading : ScreenState()
    object Success : ScreenState()
    object Failure : ScreenState()
}
