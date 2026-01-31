package com.mydomain.compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mydomain.compose_practice.ui.theme.Compose_PracticeTheme
import com.mydomain.compose_practice.view.ListOfMoviesScreen
import com.mydomain.compose_practice.view.MovieDetailsScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController= rememberNavController();
            Compose_PracticeTheme {
                Surface() {
                    NavHost(navController, startDestination = Routes.ListOfMoviesScreen.route)
                    {
                        composable(Routes.ListOfMoviesScreen.route) {
                            ListOfMoviesScreen(navController)
                        }
                        composable(Routes.MovieDetailsScreen.route) {
                            MovieDetailsScreen(navController)
                        }
                    }
                }
            }
        }
    }
}



