package com.logstream.books.exceptions;

public class BookAlreadyExistsException extends RuntimeException {
    private String isbn;

    public BookAlreadyExistsException(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return isbn;
    }
}
