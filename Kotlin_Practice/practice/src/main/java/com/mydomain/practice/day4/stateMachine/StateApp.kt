package com.mydomain.practice.day4.stateMachine

fun main()
{
   val stateMachine= StateMachine();
   val order = stateMachine.createOrder();

    stateMachine.addItem(Product(11,"Chocolate",50.6f),order)
    stateMachine.addItem(Product(12,"Cake",40.6f),order)

    stateMachine.placeOrder(order);
    stateMachine.transitionOfOrder(order);
    stateMachine.transitionOfOrder(order);
    stateMachine.transitionOfOrder(order);
    stateMachine.transitionOfOrder(order);


}