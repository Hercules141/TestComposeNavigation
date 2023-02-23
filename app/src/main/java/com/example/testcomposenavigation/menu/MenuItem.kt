package com.example.testcomposenavigation.menu

import android.view.MenuItem
import com.example.testcomposenavigation.R

data class MenuItem(
    val id: ScreensRoute,
    val textId: Int
)

val drawerScreens = listOf(
    MenuItem(ScreensRoute.Screen_1, R.string.screen_1),
    MenuItem(ScreensRoute.Screen_2, R.string.screen_2),
    MenuItem(ScreensRoute.Screen_3, R.string.screen_3),
)

enum class ScreensRoute{
    Screen_1, Screen_2, Screen_3
}