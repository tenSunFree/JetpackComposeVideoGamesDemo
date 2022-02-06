package com.example.jetpackcomposevideogamesdemo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.jetpackcomposevideogamesdemo.presentation.common.JCVGDApp
import com.example.jetpackcomposevideogamesdemo.presentation.common.base.BaseActivity
import com.example.jetpackcomposevideogamesdemo.presentation.common.theme.JCVGDTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent { JCVGDTheme { JCVGDApp() } }
    }
}