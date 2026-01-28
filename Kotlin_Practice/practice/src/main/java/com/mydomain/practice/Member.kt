package com.mydomain.practice

 class Member(id:Int,name:String) {

    val memberId = id
    val memberName= name

     override fun toString(): String {
         return "Member($memberId , $memberName)"
     }
//    fun depositBook()
//    {
//
//    }
//    fun borrowBook(bookName:String,libcard: Library):Boolean
//    {
//        val listOfBooks = libcard.listOfBooks;
//        var book:Book;
//        for(i in 0..<listOfBooks.size)
//        {
//             book = listOfBooks[i];
//            if(book.bookName==bookName && book.isAvailableInLib())
//            {
//                book.getBook();
//                return  true;
//            }
//        }
//        return  false;
//    }
}