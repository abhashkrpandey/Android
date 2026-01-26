package com.example.myapplication

sealed class Routes(val route:String) {
     object SpalshScreen:Routes("splash_screen")
    object Screen1:Routes("main_screen")
    object  Screen2: Routes("second_screen/{name}")

    object LoginPage:Routes("login_page")
    object SignupPage:Routes("sign_up")

    object HomeScreen:Routes("home_screen")
}