package com.mydomain.compose_practice.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Counter(modifier: Modifier = Modifier) {

    var count by rememberSaveable{
        mutableStateOf(0)
    }

    Column(modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(text="$count")
        Row()
        {
            Button(onClick = {
                count--
            }){
                Text(text="Decrease")
            }
            Button(onClick = {
                count=0
            }) {
                Text(text="Reset")
            }
            Button(onClick = {
                count++
            }) {
                Text(text="Increment")
            }
        }

    }
}