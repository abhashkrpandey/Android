package com.mydomain.compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.navigation.navDeepLink
import com.mydomain.compose_practice.ui.theme.Compose_PracticeTheme
import com.mydomain.compose_practice.view.ListOfMoviesScreen
import com.mydomain.compose_practice.view.MovieDetailsScreen
import com.mydomain.compose_practice.view.LoadingScreen
import com.mydomain.compose_practice.view.MovieScreen

/*
oncreate
onStart
onResume
onPause
onStop
onRestart
ondestroy
 */
val localThemeIsDark = compositionLocalOf<MutableState<Boolean>>{
    error("Message")
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println("OnCreate was called")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController= rememberNavController();
            val isDark =  remember { mutableStateOf(false) }
            var pageNumber = rememberPagerState(initialPage = 0) {
                3
            }
            Compose_PracticeTheme(darkTheme = isDark.value) {
                Surface() {
                    CompositionLocalProvider(localThemeIsDark  provides isDark) {
                    NavHost(navController, startDestination = Routes.LoadingScreen.route)
                    {
                        composable(Routes.LoadingScreen.route) {
                            LoadingScreen(navController)
                        }
                        composable(Routes.ListOfMoviesScreen.route) {
                            ListOfMoviesScreen(navController)
                        }
                        composable(route=Routes.MovieDetailsScreen.route,
                            ) {
                            MovieDetailsScreen(navController)
                        }
                        composable(route=Routes.MovieScreen.route,
                            deepLinks = listOf(
                                navDeepLink {
                                    uriPattern="app://movie/10"
                                }
                            ),
                            ) {
                            backStackEntry->

                            val id = backStackEntry.arguments?.getString("id")

                            MovieScreen(id)
                        }

                    }
                }
                }
            }
        }
    }
    override  fun onStart(){
        super.onStart()
        println("onStart was called");
    }

    override fun onResume() {
        super.onResume()
        println("onResume was called");
    }

    override fun onPause() {
        println("onPause was called");
        super.onPause()
    }

    override fun onStop() {
        println("onStop was called")
        super.onStop()
    }

    override fun onRestart() {
        println("onRestart was called")
        super.onRestart()
    }

    override fun onDestroy() {
        println("onDestroy was called")
        super.onDestroy()
    }
}



