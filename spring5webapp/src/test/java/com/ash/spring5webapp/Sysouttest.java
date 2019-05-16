package com.ash.spring5webapp;

import com.ash.spring5webapp.model.Author;
import com.ash.spring5webapp.model.Book;
import com.ash.spring5webapp.model.Publisher;

public class Sysouttest {
    public static void main(String[] args) {

        Author amit = new Author("Amit","Singh");
        Publisher publisher = new Publisher("tata1","Indore");
        Book book= new Book("J2EE","1234",publisher);
        amit.getBooks().add(book);
        book.getAuthors().add(amit);
        System.out.println(amit);
    }
}
