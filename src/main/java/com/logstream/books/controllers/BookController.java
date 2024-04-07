package com.logstream.books.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.logstream.books.models.Book;
import com.logstream.books.services.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BookController {
    final private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public Iterable<Book> getAllBooks() {
        Iterable<Book> books = bookService.getAllBooks();
        return books;
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Optional<Book> book = bookService.getBookByIsbn(isbn);
        
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(book.get());
    }

    @PostMapping("/")
    public ResponseEntity<?> postBook(@RequestBody Book book) {
        bookService.createBook(book);

        return ResponseEntity
            .status(HttpStatus.OK)
            .build();
    }

    @PutMapping("/")
    public ResponseEntity<?> putBook(@RequestBody Book book) {
        bookService.updateBook(book);

        return ResponseEntity
            .status(HttpStatus.OK)
            .build();
    }
    
    @DeleteMapping("/isbn/{isbn}")
    public ResponseEntity<?> deleteBookByIsbn(@PathVariable String isbn) {
        bookService.deleteBookByIsbn(isbn);

        return ResponseEntity
            .status(HttpStatus.OK)
            .build();
    }
}
