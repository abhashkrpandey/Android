package com.mydomain.compose_practice

sealed class Routes(val route:String) {
      object ListOfMoviesScreen :Routes("listOfMoviesScreen")
      object   MovieDetailsScreen :Routes("movieDetails")
}