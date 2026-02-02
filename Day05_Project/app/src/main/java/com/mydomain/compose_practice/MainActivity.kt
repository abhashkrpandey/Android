package com.mydomain.compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mydomain.compose_practice.ui.theme.Compose_PracticeTheme
import com.mydomain.compose_practice.view.ListOfMoviesScreen
import com.mydomain.compose_practice.view.MovieDetailsScreen
import com.mydomain.compose_practice.view.LoadingScreen


val localThemeIsDark = compositionLocalOf<MutableState<Boolean>>{
    error("Message")
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController= rememberNavController();
            val isDark =  remember { mutableStateOf(false) }
            Compose_PracticeTheme(darkTheme = isDark.value) {
                Surface() {
                    CompositionLocalProvider(localThemeIsDark  provides isDark) {
                    NavHost(navController, startDestination = Routes.LoadingScreen.route)
                    {
                        composable(Routes.ListOfMoviesScreen.route) {
                            ListOfMoviesScreen(navController)
                        }
                        composable(Routes.MovieDetailsScreen.route) {
                            MovieDetailsScreen(navController)
                        }
                        composable(Routes.LoadingScreen.route) {
                            LoadingScreen(navController)
                        }
                    }
                }
                }
            }
        }
    }
}



