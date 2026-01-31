package com.mydomain.compose_practice.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mydomain.compose_practice.Routes
import com.mydomain.compose_practice.models.Movie
import com.mydomain.compose_practice.ui.theme.Compose_PracticeTheme

@Composable
fun ListOfMoviesScreen(navController: NavController)
{
      val listOfMovies = arrayListOf(
          Movie(1,"Movie_1",8.9f)
          ,Movie(2,"Movie_2",7.5f)
          ,Movie(3,"Movie_3",5.9f)
          ,Movie(4,"Movie_4",3.9f)
          ,Movie(5,"Movie_5",8.9f),
          Movie(6,"Movie_6",8.1f)
      )
    val listState = remember { mutableStateOf(listOfMovies) }
    LazyColumn(modifier = Modifier
        .padding(50.dp)
        .fillMaxSize(), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        items(listState.value)
        { it->
            Text(text= it.movieName, modifier = Modifier.clickable(onClick = {
                navController.currentBackStackEntry?.savedStateHandle?.set("movie",it)
                println(it)
                navController.navigate(Routes.MovieDetailsScreen.route)
            }))
            HorizontalDivider(thickness = 3.dp)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Previewer() {
    Compose_PracticeTheme() {
        val navController= rememberNavController();
        ListOfMoviesScreen(navController)
    }
}
