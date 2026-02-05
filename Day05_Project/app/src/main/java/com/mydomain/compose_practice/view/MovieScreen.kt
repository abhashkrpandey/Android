package com.mydomain.compose_practice.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.mydomain.compose_practice.R

@Composable
fun MovieScreen(id: String?) {
    Column(modifier = Modifier.padding(dimensionResource(R.dimen.top_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
           if(id==null)
           {
               Text(text="0")
           }
           else{
               Text(text=id)
           }
    }
}