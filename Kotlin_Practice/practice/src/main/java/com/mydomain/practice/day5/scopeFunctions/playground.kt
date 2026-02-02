package com.mydomain.practice.day5.scopeFunctions

fun main()
{
    var user : User? = User()


    val updateUser=user?.let { it->
        it.apply {
            name="Abhash"
            age=22
            email="xyz@gmail.com"
        }.also { it ->
            it.age+=5
            it.name+=" Pandey"
//            println("${it.age}")
        }
    }
    println(updateUser)
   val updatedUser= updateUser?.run {
        age+=5;
       this
    }
    println(updatedUser)

    updatedUser?.let { it ->
        println(it.age)
        println(it.name)
        println(it.email)
    }

    println(user)



}