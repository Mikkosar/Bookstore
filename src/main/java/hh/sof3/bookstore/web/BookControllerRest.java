package hh.sof3.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin
@Controller
public class BookControllerRest {

    @Autowired
    private BookRepository bookRepository;

    //RESTful service to get all books
    @GetMapping(value = "/books")
    public @ResponseBody List<Book> findAllStudent() {
        return (List<Book>) bookRepository.findAll();
    }

    //RESTful service to get book by ID
    @GetMapping(value = "/books/{id}")
    public @ResponseBody Optional<Book> bookById(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }
}
