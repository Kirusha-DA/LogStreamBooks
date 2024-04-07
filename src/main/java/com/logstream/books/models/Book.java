package com.logstream.books.models;

import org.springframework.data.annotation.Id;

public class Book {
    
    @Id
    private String isbn;

    private String title;

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
