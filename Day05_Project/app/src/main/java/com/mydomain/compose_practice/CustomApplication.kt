package com.mydomain.compose_practice

import android.app.Application

class CustomApplication: Application() {
    override fun onCreate() {
        println("Application has started")
        super.onCreate()
    }

    override fun onTerminate() {
        println("Application has end")
        super.onTerminate()
    }
}