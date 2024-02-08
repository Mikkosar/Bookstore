package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof3.bookstore.domain.BookRepository;



@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //Returns welcome text
    //http://localhost:8080/index

    @GetMapping(value = "/index")
    public String bookStore(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "index"; //index.html
    }
}
