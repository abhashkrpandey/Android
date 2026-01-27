package com.mydomain.weather_app.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mydomain.weather_app.model.PostItem
import com.mydomain.weather_app.viewmodel.PostPageViewModel


@Composable
fun PostScreen() {
    var postPageViewModel: PostPageViewModel= viewModel();
    var posts = postPageViewModel.readOnlyState.collectAsState();
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            postPageViewModel.fetchPost();
        }, modifier = Modifier.padding(top = 50.dp)) {
            Text(text="Fetch Post")
        }
        LazyColumn() {

            items(posts.value)
            { it ->
                Post(it)
                HorizontalDivider(thickness = 3.dp)
            }
        }
    }
}

@Composable
fun Post(postItem: PostItem)
{
    Column() {
        Row()
        {
            Text(text="Body:", fontWeight = FontWeight.Bold)
            Text(text = postItem.body)
        }
        Row()
        {
            Text(text="Id:", fontWeight = FontWeight.Bold)
            Text(text="${postItem.id}")
        }
        Row()
        {
            Text(text="Title:", fontWeight = FontWeight.Bold)
            Text(text=postItem.title)
        }
        Row()
        {
            Text(text="PostItem:", fontWeight = FontWeight.Bold)
            Text(text="${postItem.userId}")
        }
    }
}