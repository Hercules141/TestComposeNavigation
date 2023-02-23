package com.example.testcomposenavigation.menu

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ComposeMenu(
    menuItems: List<MenuItem>,
    scaffoldState: ScaffoldState,       // todo no clue why this needs to be here, find out -> kind of "base layout and seems like it gives access to "App features like TopAppBar, MenuDrawer etc."
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
    onItemClick: (MenuItem) -> Unit
){
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
            .padding(15.dp)
    ){
        items(menuItems){ item ->
            ComposeMenuItem(
                menuItem = item,
                modifier = modifier
                    .padding(15.dp)
            ){
                // here the drawer would normally be closed with a "scope" launch whatever scope that is and a scaffoldState
                scope.launch{
                    scaffoldState.drawerState.close()
                }
                onItemClick(item)
            }
        }
    }
}