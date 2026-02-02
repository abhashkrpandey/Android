package com.mydomain.practice.day4.stateMachine

class StateMachine {
    var orders = mutableMapOf<Int, Order>()
    var orderCounter=1;
    fun createOrder():Order
    {
        val order = Order(orderCounter,0f, ArrayList(), OrderStatus.PENDING)
         orders[orderCounter++]= order
        return  order
    }
    fun addItem(product: Product,order: Order)
    {
        if(order.orderStatus== OrderStatus.PENDING) {
            order.listOfProduct.add(product);
            order.orderPrice += product.price;
            println("Order is of now ${order.orderPrice}")
        }
    }
    fun placeOrder(order: Order)
    {
        if(order.orderStatus== OrderStatus.PENDING) {
            order.orderStatus = OrderStatus.PLACED
            println("Order is placed")
        }
        else
        {
            println("Warning:Create a new order");
        }
    }
   private fun shipOrder(order: Order)
    {
        order.orderStatus= OrderStatus.SHIPPED
        println("Order is now shipped")
    }
   private fun deliverOrder(order: Order)
    {
        order.orderStatus= OrderStatus.DELIVERED
        println("Order is delivered")

    }
    fun transitionOfOrder(order:Order)
    {
        if(order.orderStatus== OrderStatus.PLACED)
        {
            shipOrder(order)
        }
       else if(order.orderStatus== OrderStatus.SHIPPED)
        {
            deliverOrder(order)
        }
        else
        {
            println("Warning:Create a new order");
        }
    }
}