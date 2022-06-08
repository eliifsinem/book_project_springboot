package Assigment.book.repository;

import Assigment.book.model.book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface bookRepository extends MongoRepository<book,String> {

    Optional<book> findById(Integer id);
}
