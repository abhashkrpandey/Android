package com.mydomain.weather_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.mydomain.weather_app.ui.theme.Weather_AppTheme
import com.mydomain.weather_app.view.PostScreen

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Weather_AppTheme {
                Surface() {
                    PostScreen()
                }
            }
        }
    }
}

