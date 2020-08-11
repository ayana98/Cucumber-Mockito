package com.lxisoft.school.mockito;

import java.util.ArrayList;
import java.util.List;

public class BookResource {

    public BookService bookService;

    public BookResource(BookService bookService){
        this.bookService = bookService;
    }

    public List<String> getBooksforHibernate(String name) {

        List<String> hibernatelist = new ArrayList<String>();
        List<String> Combinedlist =  bookService.getBooks(name);

        for(String book: Combinedlist) {
            if(book.contains("Hibernate")) {
                hibernatelist.add(book);
            }
        }

        return hibernatelist;
    }

    }
