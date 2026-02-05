package com.mydomain.compose_practice.view

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mydomain.compose_practice.R
import com.mydomain.compose_practice.models.Movie
import com.mydomain.compose_practice.ui.theme.Compose_PracticeTheme
import java.lang.Package.getPackage
import androidx.core.net.toUri
import com.mydomain.compose_practice.Routes


@Composable
fun MovieDetailsScreen(navController: NavController)
{
    val context = LocalContext.current
    val movie =navController.previousBackStackEntry?.savedStateHandle?.get<Movie>("movie")
     println(movie)
      Column(
          modifier = Modifier.fillMaxSize().padding(dimensionResource(R.dimen.top_padding)),
          horizontalAlignment = Alignment.CenterHorizontally,
      )
      {
          movie?.let {  it ->
              Text(text=it.movieName)
              Text(text="${it.movieId}")
              Text(text="${it.rating}")

          }
          Button(onClick = {
              val browserIntent: Intent= Intent().apply {
                  action=Intent.ACTION_VIEW
                  data= Uri.parse(context.getString(R.string.browserLink))
              }
              if (browserIntent.resolveActivity(context.packageManager) != null) {
                  context.startActivity(browserIntent)
              }
          }) {
              Text(text="Open website");
          }
          Button(onClick = {
              val cameraIntent: Intent = Intent().apply {
                  action= MediaStore.ACTION_IMAGE_CAPTURE
              }
                   context.startActivity(cameraIntent)
          }){
              Text(text="Open Camera")
          }
          Button(onClick = {
              navController.navigate("movie/10")
          }) {
              Text("Click for next page")
          }
          Toast.makeText(context, stringResource(R.string.author,"Abhash",22),Toast.LENGTH_LONG).show()
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