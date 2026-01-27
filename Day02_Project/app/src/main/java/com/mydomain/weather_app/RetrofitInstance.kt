package com.mydomain.weather_app

import com.mydomain.weather_app.api.ApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    var BASE_URL="https://jsonplaceholder.typicode.com"

    val retrofit  by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiInterface by lazy{
        retrofit.create(ApiServices::class.java)
    }
}