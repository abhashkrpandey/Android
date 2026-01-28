package com.mydomain.practice

fun main()
{
    println("enter the number of subjects:")
    val subNum:Int?=readln().toIntOrNull()
    val marksList: ArrayList<Float?> = ArrayList();
    if(subNum!=null) {
        for (i in 1..subNum) {
            println("enter your marks in sub $i:")
            marksList.add(readln().toFloatOrNull())
        }

        var sum = 0f
        for (i in 0..< marksList.size) {
            sum += marksList[i] ?: 0f
        }
        val percentage: Float = sum / (subNum)
        val gpa = percentage/25

        println("Your gpa is :$gpa")
    }
}