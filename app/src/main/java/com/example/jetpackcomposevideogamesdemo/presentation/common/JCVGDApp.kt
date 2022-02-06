package com.example.jetpackcomposevideogamesdemo.presentation.common

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposevideogamesdemo.presentation.common.Destinations.Home
import com.example.jetpackcomposevideogamesdemo.presentation.home.view.HomeScreen

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun JCVGDApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable(Home) { HomeScreen() }
    }
}