package com.mydomain.practice

fun main()
{
    val isPasswordValid = createValidator(8)

    println(isPasswordValid("secret"))
    println(isPasswordValid("secret123"))
    println(isPasswordValid(null))

    var count = counter()
    count()
    count()
    count()


}
fun createValidator(len:Int) : (string:String?)-> Boolean
{
    return {
        string:String? ->
        if(string==null || string.length<len)
             false
        else
             true
    }
}
fun counter():()->Unit
{
    var value=0;
    return {
        value+=1
        println(value)
    }
}