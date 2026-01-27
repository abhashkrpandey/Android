package com.mydomain.weather_app.api

import com.mydomain.weather_app.model.PostItem
import retrofit2.http.GET

interface ApiServices {
    @GET("/posts")
    suspend fun getPost() : ArrayList<PostItem>
}