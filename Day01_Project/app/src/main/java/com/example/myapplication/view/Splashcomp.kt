package com.example.myapplication.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Routes
import com.example.myapplication.repositry.Repositry
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay



@Composable
fun Splashcomp(navController: NavController,appRepo: Repositry)
{
    var animationStart by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if(animationStart)1.2f else 0f,
        animationSpec = tween(durationMillis = 5000)
    )
    val alpha by animateFloatAsState(
        targetValue = if(animationStart) 1f else 0f,
        animationSpec = tween(durationMillis = 5000)
    )
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text("My app", modifier = Modifier.scale(scale).alpha(alpha))
        }
    LaunchedEffect(Unit) {
        animationStart=true
        delay(5000)
        if(appRepo.validUser())
        {
            println("Login");
            navController.navigate(Routes.LoginPage.route)
            {
                popUpTo(0)
            }
        }
        else
        {
            println("Signup");
            navController.navigate(Routes.SignupPage.route)
            { popUpTo(0)
            }
        }
    }
}