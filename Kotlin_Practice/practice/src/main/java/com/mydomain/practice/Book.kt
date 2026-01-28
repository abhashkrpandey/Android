package com.mydomain.practice

 class Book(id:Int,name:String,price:Float,author:String)
{
    val bookId =id
    val bookName=name
    val bookPrice=price
    val bookAuthor=author

    override fun toString(): String {
        return  "Book($bookId, $bookName, $bookPrice, $bookAuthor)"
    }
    private var isAvailable:Boolean=true

    fun isAvailableInLib(): Boolean{
        return isAvailable;
    }

    fun getBook():Unit
    {
        if(isAvailableInLib())
            isAvailable=false;
        else
            isAvailable=true
    }
}