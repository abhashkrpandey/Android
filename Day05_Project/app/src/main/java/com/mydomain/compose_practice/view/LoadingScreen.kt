package com.mydomain.compose_practice.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mydomain.compose_practice.Routes
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(navController: NavController) {

    var loading = remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(3000)
        loading.value=false
    }
    if(loading.value)
    {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            )
         {
            CircularProgressIndicator()
        }
    }
    else{
        navController.popBackStack();
        navController.navigate(Routes.ListOfMoviesScreen.route)
    }

}