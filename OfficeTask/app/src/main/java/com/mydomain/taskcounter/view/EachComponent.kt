package com.mydomain.taskcounter.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mydomain.taskcounter.ui.theme.TaskCounterTheme
import kotlinx.coroutines.delay


@Preview(showBackground = true)
@Composable
private fun Previewer() {
    TaskCounterTheme() {
        EachElement("Counter 0", counterStateToggle = {},deleteItem={}, getCount = { "" },changeTime={})
    }
}

@Composable
fun EachElement(title: String, counterStateToggle: () -> Unit,deleteItem:()->Unit, getCount: () -> String,changeTime:(Int)->Unit) {
    DisposableEffect(Unit) {
        counterStateToggle()
        onDispose {
            counterStateToggle()
        }
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    )
    {
        Text(text = title)
        Button(
            onClick = {
                changeTime(1)
            }
        )
        {
            Text(text = "+")
        }
        Button(
            onClick = {
               deleteItem()
            }
        )
        {
            Text(text = "Delete")
        }
        Button(
            onClick = {
               changeTime(-1)
            }
        ) {
            Text(text = "-")
        }
        Text(text = getCount())
    }
}
