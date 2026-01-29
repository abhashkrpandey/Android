package com.mydomain.practice.day4.paymentProccesor

import java.lang.Thread.sleep
import kotlin.concurrent.thread

class CreditCard: PaymentProccessor {
  private  fun validateCredentials(): Boolean
    {
        var value: Boolean=true;
       val t1=  thread{
            Thread.sleep(2000)
            value=true;
        }
        val t2 = thread {
            Thread.sleep(2000)
            value=false;
        }
        t1.join();
        t2.join();
        return  value;
    }
    override fun doPayment() {
        if(validateCredentials())
        {
            println("Payment Done")
        }
        else
        {
            println("Paymemt Failed")
        }
    }
}