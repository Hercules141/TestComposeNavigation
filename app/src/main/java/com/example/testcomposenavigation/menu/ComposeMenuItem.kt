package com.example.testcomposenavigation.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComposeMenuItem(menuItem: MenuItem, modifier: Modifier =  Modifier, onItemClick: (MenuItem) -> Unit){
    Row(
        Modifier
            .clickable { onItemClick(menuItem) }

    ){
        Text(
            text = stringResource(id = menuItem.textId),
            fontSize = 25.sp,
            modifier = Modifier
                .padding(15.dp)

        )
    }
    Divider()
}