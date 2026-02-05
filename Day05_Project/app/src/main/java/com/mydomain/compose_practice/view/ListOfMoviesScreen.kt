package com.mydomain.compose_practice.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.mydomain.compose_practice.R
import com.mydomain.compose_practice.Routes
import com.mydomain.compose_practice.localThemeIsDark
import com.mydomain.compose_practice.models.Movie
import com.mydomain.compose_practice.ui.theme.Compose_PracticeTheme
import com.mydomain.compose_practice.ui.theme.Pink40
import com.mydomain.compose_practice.ui.theme.movie1Url
import com.mydomain.compose_practice.ui.theme.movie2Url
import com.mydomain.compose_practice.ui.theme.movie3Url
import com.mydomain.compose_practice.ui.theme.movie4Url
import com.mydomain.compose_practice.ui.theme.movie5Url
import com.mydomain.compose_practice.ui.theme.movie6Url

@Composable
fun ListOfMoviesScreen(navController: NavController)
{
      var isDark = localThemeIsDark.current
      val listOfMovies = arrayListOf(
          Movie(
              1,
              "Movie_1",
              8.9f,
              url = movie1Url,
              contentDescription = "fight club"
          )
          ,Movie(
              2, "Movie_2", 7.5f, url = movie2Url,
              contentDescription = "Jesse Jones",
          )
          ,Movie(3,"Movie_3",5.9f,url= movie3Url, contentDescription = "Shutter Island")
          ,Movie(4,"Movie_4",3.9f, url = movie4Url, contentDescription = "Jesse Jones")
          ,Movie(5,"Movie_5",8.9f,url = movie5Url, contentDescription = "Jesse Jones"),
          Movie(6,"Movie_6",8.1f,url = movie6Url, contentDescription = "Jesse Jones")
      )
    val listState = remember { mutableStateOf(listOfMovies) }
    Column(modifier = Modifier.padding(dimensionResource(R.dimen.top_padding)).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Button(onClick = {
             isDark.value=!isDark.value
        }) {
          Text("Change Theme")
        }
        LazyColumn(
            modifier = Modifier
                .padding()
                .fillMaxSize(), verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(listState.value)
            { it ->
                AsyncImage(
                    model = it.url,
                    contentDescription = it.contentDescription,
                    placeholder = ColorPainter(Pink40),
                    modifier = Modifier.size(150.dp)
                )
                Text(text = it.movieName, modifier = Modifier.clickable(onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("movie", it)
                    println(it)
                    navController.navigate(Routes.MovieDetailsScreen.route)
                }))
                HorizontalDivider(thickness = 3.dp)
            }
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

