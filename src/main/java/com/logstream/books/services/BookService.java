package com.logstream.books.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.logstream.books.exceptions.BookAlreadyExistsException;
import com.logstream.books.exceptions.BookNotFoundException;
import com.logstream.books.models.Book;
import com.logstream.books.repositories.PostgresBookRepository;

@Service
public class BookService {
    
    private final PostgresBookRepository bookRepository;

    public BookService(PostgresBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAllBooks() {
        Iterable<Book> books = bookRepository.findAll();
        return books;
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        if (book.isEmpty()) {
            throw new BookNotFoundException(isbn);
        }
        return book;
    }

    public void createBook(Book book) {
        try {
            bookRepository.createBook(book.getIsbn(), book.getTitle());
        } catch (RuntimeException ex) {
            throw new BookAlreadyExistsException(book.getIsbn());
        }
    }

    public void updateBook(Book book) {
        try {
            bookRepository.save(book);
        } catch (BookNotFoundException ex) {
            throw new BookNotFoundException(book.getIsbn());
        }
    }

    public void deleteBookByIsbn(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
