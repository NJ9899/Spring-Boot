package com.student.ust.controller;

import com.student.ust.entity.Book;
import com.student.ust.entity.Student;
import com.student.ust.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void addBook(@RequestBody Book book){
        bookService.createBook(book);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> get(@PathVariable Integer id){
        try{
            Book getBook = bookService.getById(id);
            return new ResponseEntity<Book>(getBook, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> get(){
        try{
            List<Book> allBook = bookService.getAllBook();
            return new ResponseEntity<List<Book>>(allBook,HttpStatus.OK);
        }
        catch(NoSuchElementException e)
        {
            return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable Integer id){
        bookService.deleteBooks(id);
    }

    @PutMapping("/book")
    public ResponseEntity<Book> update(@RequestBody Book book){
        try{
            Book bookUpdate = bookService.updateBook(book);
            return new ResponseEntity<Book>(bookUpdate,HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

    }

}
