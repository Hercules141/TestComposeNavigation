package com.example.testcomposenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.testcomposenavigation.menu.ComposeMenu
import com.example.testcomposenavigation.menu.NavHost
import com.example.testcomposenavigation.menu.screenMenuItems
import com.example.testcomposenavigation.ui.theme.TestComposeNavigationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*TestComposeNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }*/

        }
    }
}

@Preview (showBackground = true)
@Composable
fun NavigationMenuScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                titleResId = R.string.app_name,
            ){
                scope.launch{
                    scaffoldState.drawerState.open()
                }
            }
        },
        drawerGesturesEnabled = true,
        drawerContent = {
            ComposeMenu(
                menuItems = screenMenuItems,
                scaffoldState = scaffoldState,
                scope = scope
            ) {
//                navController.navigate(it.id.name) {
//                    popUpTo = navController.graph.startDestinationId
//                    launchSingleTop = true
//                }
                navController.navigate(it.id.name){
                    popUpToId
                    launchSingleTop = true
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navHostController = navController,
            modifier = Modifier.
                    padding(paddingValues)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    TestComposeNavigationTheme {
//        // todo preivew
//    }
//}