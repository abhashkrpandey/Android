package com.example.myapplication.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Routes
import com.example.myapplication.repositry.Repositry

@Composable
fun NewAppNavigation(appRepo: Repositry)
{
    var navController= rememberNavController();

    NavHost(navController, startDestination = Routes.SpalshScreen.route)
    {
        composable(Routes.SpalshScreen.route)
        {
            Splashcomp(navController,appRepo)
        }
        composable(Routes.LoginPage.route)
        {
            LoginPage(navController,appRepo)
        }
        composable(Routes.SignupPage.route) {
            Signup(navController,appRepo)
        }
        composable(Routes.HomeScreen.route)
        {
            HomeScreen(navController,appRepo)
        }
    }
}