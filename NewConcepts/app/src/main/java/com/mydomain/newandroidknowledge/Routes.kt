package com.mydomain.newandroidknowledge

sealed  class Routes(val route:String) {
    object  LoadingPage:Routes(route="loading_screen")
    object  TodoPage:Routes(route="todo_screen")
}