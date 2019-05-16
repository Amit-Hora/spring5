package com.ash.spring5webapp.controller;

import com.ash.spring5webapp.repositories.AuthorRepository;
import com.ash.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository,AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books",bookRepository.findAll());
        System.out.println(bookRepository.findAll());
        return "books";
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepository.findAll());
        System.out.println(authorRepository.findAll());
        return "authors";
    }
}
