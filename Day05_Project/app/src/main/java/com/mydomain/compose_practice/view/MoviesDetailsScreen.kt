package com.mydomain.compose_practice.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mydomain.compose_practice.models.Movie
import com.mydomain.compose_practice.ui.theme.Compose_PracticeTheme


@Composable
fun MovieDetailsScreen(navController: NavController)
{
    val movie =navController.previousBackStackEntry?.savedStateHandle?.get<Movie>("movie")
     println(movie)
      Column(modifier = Modifier.fillMaxSize().padding(50.dp)
          , horizontalAlignment = Alignment.CenterHorizontally,)
      {
          movie?.let {  it ->
              Text(text=it.movieName)
              Text(text="${it.movieId}")
              Text(text="${it.rating}")

          }
      }
}
@Preview(showSystemUi = true)
@Composable
private fun Previewer() {
    Compose_PracticeTheme() {
        val navController= rememberNavController();
        MovieDetailsScreen(navController)
    }
}