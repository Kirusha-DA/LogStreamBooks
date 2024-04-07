package com.logstream.books.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.logstream.books.exceptions.BookAlreadyExistsException;
import com.logstream.books.exceptions.BookNotFoundException;
import com.logstream.books.models.ErrorDetails;

@RestControllerAdvice
public class ExceptionBookControllerAdvice {
    
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionNotFoundHandler(BookNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        String msg = String.format("isbn: %s was not found", ex);
        errorDetails.setMessage(msg);

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errorDetails);
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> exceptionAlreadyExistsHandler(BookAlreadyExistsException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        String msg = String.format("isbn: %s already exists", ex);
        errorDetails.setMessage(msg);

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errorDetails);
    }
}
