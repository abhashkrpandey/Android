package com.mydomain.practice


class Library {

    val listOfBooks = arrayListOf<Book>()
    val listOfMembers = arrayListOf<Member>()

    fun addBookInLib(id:Int,bookName:String,price:Float,authorName:String)
    {
        listOfBooks.add(Book(id,bookName,price,authorName))
        val book = listOfBooks[listOfBooks.size-1]
        println("${book.toString()} has been added")
    }
    fun validBook(name:String): Boolean
    {
        for(i in 0 .. listOfBooks.size-1)
        {
            if(listOfBooks[i].bookName==name)
            {
                return  true
            }
        }
        return  false
    }
    fun validUser(name:String): Boolean
    {
     for(i in 0..<listOfMembers.size)
     {
         if(listOfMembers[i].memberName==name)
         {
             return  true
         }
     }
        return  false
    }
    fun addMemInLib(id:Int,name:String)
    {
        listOfMembers.add(Member(id,name))
        val member  = listOfMembers[listOfMembers.size-1]
        println("${member.toString()} has been added")
    }
    fun provideBook(member: Member,book:Book): Boolean
    {
        if(validUser(member.memberName) && validBook(book.bookName) && book.isAvailableInLib())
        {
            book.getBook()
            println("${member.memberName} has been provided ${book.bookName}")
            return true
        }
        println("${member.memberName} has not been provided ${book.bookName}")
        return  false
    }
    fun acceptBook(member: Member,book:Book): Boolean
    {
        if(validUser(member.memberName) && validBook(book.bookName) &&  !book.isAvailableInLib())
        {
            book.getBook()
            println("${member.memberName} has returned ${book.bookName}")
            return true
        }
        println("${member.memberName} has failed to return ${book.bookName}")
        return  false
    }
}