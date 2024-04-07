package com.logstream.books.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.logstream.books.models.Book;

@Repository
public interface PostgresBookRepository extends CrudRepository<Book, String> {

    @Modifying
    @Query("INSERT INTO book VALUES (:isbn, :title)")
    void createBook(String isbn, String title);
} 