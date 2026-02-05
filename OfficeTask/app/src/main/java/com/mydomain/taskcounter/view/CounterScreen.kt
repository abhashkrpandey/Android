package com.mydomain.taskcounter.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mydomain.taskcounter.Counter
import com.mydomain.taskcounter.CounterViewModel
import com.mydomain.taskcounter.ui.theme.TaskCounterTheme
import kotlinx.coroutines.delay


@Preview(showSystemUi = true)
@Composable
private fun Previewer1() {
    TaskCounterTheme() {
        CounterScreen()
    }
}


@Composable
fun CounterScreen() {

    val viewModel: CounterViewModel = viewModel()
    val listOfCounter = viewModel.listOfCounter.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(all=30.dp), verticalArrangement = Arrangement.spacedBy(space=30.dp)
    ) {

        itemsIndexed(items = listOfCounter.value,key={_,item->item.title})
        { index, item ->
            EachElement(
                item.title,
                counterStateToggle = {
                    viewModel.toggleTimer(item.title)
                },
                deleteItem = {
                    viewModel.deleteItem(item.title)
                }, getCount={
                    item.count.toString()
                }, changeTime = { value: Int ->
                    viewModel.changeTimeWitButton(value, item.title)
                })
        }
    }
}

