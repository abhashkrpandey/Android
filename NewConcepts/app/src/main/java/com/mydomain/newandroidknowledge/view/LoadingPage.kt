package com.mydomain.newandroidknowledge.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.mydomain.newandroidknowledge.R
import com.mydomain.newandroidknowledge.Routes
import kotlinx.coroutines.delay

@Composable
fun LoadingPage(navController: NavController) {
    var isLoading = remember { mutableStateOf(true) }
    Column(modifier= Modifier.padding(dimensionResource(R.dimen.top_padding))) {

        LaunchedEffect(Unit) {
            delay(3000)
            isLoading.value=false
        }
        if(isLoading.value)
        {
            CircularProgressIndicator()
        }
        else{
            navController.navigate(Routes.TodoPage.route)
        }
    }

}