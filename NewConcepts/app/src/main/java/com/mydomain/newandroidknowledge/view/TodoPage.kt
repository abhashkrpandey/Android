package com.mydomain.newandroidknowledge.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mydomain.newandroidknowledge.R
import com.mydomain.newandroidknowledge.Routes
import com.mydomain.newandroidknowledge.ui.theme.NewAndroidKnowledgeTheme

@Preview(showSystemUi = true)
@Composable
fun Previewer()
{
    val navController= rememberNavController()
    NewAndroidKnowledgeTheme() {
        TodoPage(navController)
    }
}

@Composable
fun TodoPage(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(dimensionResource(R.dimen.top_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
        ) {
        Button(onClick = {
                
        }) {
            Text("Add Task")
        }
    }
}

@Composable
fun DailogBox()
{
    AlertDialog(
        title = { Text("Add task") },
        text = {

        },
        dismissButton = {

        },
        onDismissRequest = {

        },
        confirmButton= {

        }
    )
}