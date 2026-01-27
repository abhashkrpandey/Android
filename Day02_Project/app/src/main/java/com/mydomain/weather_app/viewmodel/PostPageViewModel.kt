package com.mydomain.weather_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mydomain.weather_app.RetrofitInstance
import com.mydomain.weather_app.model.PostItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostPageViewModel: ViewModel() {

   private var postPageViewModelState = MutableStateFlow<List<PostItem>>(emptyList());
    val readOnlyState =postPageViewModelState.asStateFlow();

    fun fetchPost()
    {
        println("fetching ....")
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO)
            {
                RetrofitInstance.apiInterface.getPost()
            }
            postPageViewModelState.value=result
        }
        println("fetching ends !!!")
    }
}