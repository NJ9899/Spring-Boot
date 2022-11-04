package com.student.ust.service;

import com.student.ust.entity.Book;
import com.student.ust.entity.Student;
import com.student.ust.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public Book getById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public void deleteBooks(Integer id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) {
        Book updateBook = bookRepository.findById(book.getBookId()).orElseThrow(()-> new NoSuchElementException());
        updateBook.setBookName(book.getBookName());
        updateBook.setIsbn(book.getIsbn());
        updateBook.setAuthorName(book.getAuthorName());
        bookRepository.save(updateBook);
        return updateBook;
    }
}
