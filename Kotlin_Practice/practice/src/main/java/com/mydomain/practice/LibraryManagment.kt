package com.mydomain.practice

fun main()
{
    val library= Library();
    library.addBookInLib(1,"Book1",50.4f,"Person1")
    library.addBookInLib(2,"Book2",60.4f,"Person2")
    library.addBookInLib(3,"Book3",70.4f,"Person3")

    library.addMemInLib(11,"Member1",);
    library.addMemInLib(12,"Member2");
    library.addMemInLib(13,"Member3");

    library.provideBook(library.listOfMembers[0],library.listOfBooks[0]);

    library.acceptBook(library.listOfMembers[1],library.listOfBooks[1]);

    library.provideBook(library.listOfMembers[1],library.listOfBooks[0]);

    library.provideBook(library.listOfMembers[1],library.listOfBooks[1]);


}