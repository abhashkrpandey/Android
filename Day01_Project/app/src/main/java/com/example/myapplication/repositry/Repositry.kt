package com.example.myapplication.repositry

import android.content.Context

class Repositry(context: Context) {

    private var prefi = context.getSharedPreferences("authentication",Context.MODE_PRIVATE)

    private var editor = prefi.edit();

    fun add(name:String,number: String,password:String): Boolean
    {
        try {
            editor.putString("Name", name).apply();
            editor.putString("Mobile no", number).apply()
            editor.putString("Password", password).apply()
            return true;
        }
        catch(exception: Exception)
        {
            return false
        }

    }
    fun getter(): ArrayList<String>
    {
        var values= arrayListOf(
            prefi.getString("Name","").toString(),
            prefi.getString("Mobile no","").toString(),
            prefi.getString("Password","").toString()
            )
        return values
    }
    fun validUser(): Boolean
    {
        var userInfo=getter();
        if(userInfo.get(0).length==0 || userInfo.get(1).length==0 || userInfo.get(2).length==0)
            return  false
        else
            return true
    }

}