package com.mydomain.practice.day4.stateMachine

/*
orderid,
can contain multiple products,
have a certain stage - ordered,shipped,delivered
*/
data class Order(
    val orderId:Int,
    var orderPrice:Float,
    val listOfProduct: ArrayList<Product> = ArrayList(),
    var orderStatus: OrderStatus= OrderStatus.PENDING
)