package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.myapplication.repositry.Repositry
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.view.NewAppNavigation

class MainActivity : ComponentActivity() {

    lateinit  var appRepo: Repositry;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appRepo= Repositry(this);
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface() {
                    NewAppNavigation(appRepo);
                }
            }
        }
    }
}



