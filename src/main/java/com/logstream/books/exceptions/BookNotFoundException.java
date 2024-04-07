package com.logstream.books.exceptions;

public class BookNotFoundException extends RuntimeException {
    private String isbn;

    public BookNotFoundException(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return isbn;
    }
}