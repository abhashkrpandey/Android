package com.example.myapplication.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.repositry.Repositry
import com.example.myapplication.viewModel.SignupLoginViewModel

@Composable
fun HomeScreen (navController: NavController,appRepo: Repositry) {

    var context = LocalContext.current;
    var viewModel: SignupLoginViewModel=viewModel();
    Column(modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text="Name:${viewModel.getUserInfo(appRepo).get(0)}")
        Text(text="Mobile no:${viewModel.getUserInfo(appRepo).get(1)}")
    }
}