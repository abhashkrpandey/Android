package com.mydomain.practice.day4.paymentProccesor

fun main()
{
    val paypal = Paypal()
    paypal.doPayment()
    val creditCard = CreditCard()
    creditCard.doPayment()
}