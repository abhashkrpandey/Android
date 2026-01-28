package com.mydomain.practice

//remove all null  and square even nums and add it

fun main()
{
   val numbers = listOf(1, 2, null, 3, 4, null, 6);
  val list = helper {
       numbers.filterNotNull()
   }
    println("Main Func:$list")
}
fun helper(nullRemover:()->List<Int>):List<Int>
{
    val list=  nullRemover()
    println("High-Order Func:$list")
    return list;
}
