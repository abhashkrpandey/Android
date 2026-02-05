package com.mydomain.taskcounter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {


    // for primitive datatypes only change in values are
    // required but when array is used as a state then you have to change ref
    private val _listOfCounter = MutableStateFlow<List<Counter>>(emptyList())
    val listOfCounter = _listOfCounter.asStateFlow()

    init {
        createCounterItems()
        viewModelScope.launch {
            while (true) {
                delay(1000)
                newListCreator()
            }
        }
    }

    fun newListCreator() {
        _listOfCounter.update { counters ->
            counters.map { counter ->
                if (counter.status == State.RUNNING) {
                    counter.copy(count = counter.count+1)
                } else counter
            }
        }
    }

    fun createCounterItems() {
        val list = MutableList(100)
        {
            Counter("Counter 0", 0, State.STOPPED)
        }
        repeat(100)
        { index -> list[index] = Counter("Counter $index", 0, State.STOPPED) }
        _listOfCounter.value = list
    }

    fun toggleTimer(itemTitle: String) {
        _listOfCounter.update { currentState ->
            currentState.map{  counter ->
                if (counter.title == itemTitle && counter.status== State.STOPPED) {
                    counter.copy(status = State.RUNNING)
                }
                else if(counter.title == itemTitle && counter.status== State.RUNNING)
                {
                    counter.copy(status = State.STOPPED)
                }
                else counter

            }
        }
    }

    fun deleteItem(itemTitle:String)
    {
        _listOfCounter.update { list -> list.filter { it-> it.title!=itemTitle
        } }
    }
    fun changeTimeWitButton(value:Int,itemTitle: String)
    {
            _listOfCounter.update { list -> list.map{ it ->
                if(it.title==itemTitle)
                    it.copy(title = it.title, count = it.count+value)
                else
                    it
            }}
    }

}

data class Counter(
    val title: String,
    val count: Int,
    val status: State
)

enum class State {
    RUNNING,
    STOPPED
}