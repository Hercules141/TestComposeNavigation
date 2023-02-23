package com.example.testcomposenavigation.menu

import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost      // todo note how this NavHost got severely confused with this composable
import androidx.navigation.compose.composable
import com.example.testcomposenavigation.R

@Composable
fun NavHost(
    navHostController: NavHostController,
    modifier: Modifier
){
    // note this NavHost is the standard Compose nav host not this composable
    NavHost(
        navController = navHostController,
        startDestination = ScreensRoute.Screen_1.name,
//        modifier = Modifier.padding(10.dp)
    ){
        composable(ScreensRoute.Screen_1.name){
            ScreenContent(titleId = R.string.screen_1)
        }
        composable(ScreensRoute.Screen_2.name){
            ScreenContent(titleId = R.string.screen_2)
        }
        composable(ScreensRoute.Screen_3.name){
            ScreenContent(titleId = R.string.screen_3)
        }
    }
}