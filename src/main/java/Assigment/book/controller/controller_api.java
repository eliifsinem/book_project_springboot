package Assigment.book.controller;

import Assigment.book.model.book;
import Assigment.book.service.bookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/books")
@AllArgsConstructor

public class controller_api {

    private final bookService bookService;

    @PostMapping
    public ResponseEntity<book> createBook(@RequestBody book newBook){
       return new ResponseEntity<>(bookService.createBook(newBook), CREATED);

    }

    @GetMapping
    public ResponseEntity<List<book>> getBooks(@RequestParam (required = false) String book){
        return new ResponseEntity<>(bookService.getBooks(book), OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<book> getBook(@PathVariable Integer id){
        return new ResponseEntity<>(getBookById(id),OK);
    }

    private book getBookById(Integer id) {
        return bookService.getBookById(id);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Integer id, @RequestBody book newBook){
        bookService.updateBook(id,newBook);
        return new ResponseEntity<>(OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Void>> deleteBook (@PathVariable Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(OK);
    }


}
