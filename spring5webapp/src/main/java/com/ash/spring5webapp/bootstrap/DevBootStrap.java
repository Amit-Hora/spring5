package com.ash.spring5webapp.bootstrap;

import com.ash.spring5webapp.model.Author;
import com.ash.spring5webapp.model.Book;
import com.ash.spring5webapp.model.Publisher;
import com.ash.spring5webapp.repositories.AuthorRepository;
import com.ash.spring5webapp.repositories.BookRepository;
import com.ash.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository,BookRepository bookRepository,
                        PublisherRepository publisherRepository){
        this.bookRepository=bookRepository;
        this.authorRepository=authorRepository;
        this.publisherRepository=publisherRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    // init method
    public void initData(){

        Author amit = new Author("Amit","Singh");
        Publisher publisher = new Publisher("tata1","Indore");
        Book book= new Book("J2EE","1234",publisher);
        amit.getBooks().add(book);
        book.getAuthors().add(amit);
        authorRepository.save(amit);
        publisherRepository.save(publisher);
        bookRepository.save(book);

    }
}
