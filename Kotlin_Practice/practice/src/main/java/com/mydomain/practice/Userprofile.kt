package com.mydomain.practice

data class User(
    val name:String?,
    val age:Int?,
    val height:Float?
)

fun main()
{
    println("enter your details----")
    println("enter your name:")
    val name: String? =readln().takeIf { it.isNotBlank() }
    println("enter your age:")
    val age=readln().toIntOrNull()
    println("enter your height:")
    val height=readln().toFloatOrNull()
    val user = User(name,age,height)
    println("User name: ${user.name}")
    println("User age: ${user.age}")
    println("User height: ${user.height}")

}
