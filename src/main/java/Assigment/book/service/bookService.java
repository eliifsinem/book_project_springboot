package Assigment.book.service;

import Assigment.book.model.book;
import Assigment.book.repository.bookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static javax.swing.text.html.parser.DTDConstants.ID;

@Service
@AllArgsConstructor

public class bookService {

    private final bookRepository bookRepository;

    public book createBook(book newBook) {
        return bookRepository.save(newBook);
    }

    public List<book> getBooks(String book) {
        return bookRepository.findAll();

    }

    public void updateBook(Integer id, book newBook) {
        book oldBook = getBookById(id);
        oldBook.setName(newBook.getName());
        oldBook.setDescription(newBook.getDescription());
        bookRepository.save(oldBook);


    }

    public book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book is not found"));

    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id.toString());
    }
}
