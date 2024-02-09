package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





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

    @GetMapping(value = "/add")
    public String addBook(Model model) {

        model.addAttribute("book", new Book());

        return "bookform"; // bookform.html
    }

    @PostMapping(value = "/save")
    public String saveBook(@ModelAttribute Book book) {

        bookRepository.save(book);

        return "redirect:/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long Id, Model model){

        bookRepository.deleteById(Id);

        return "redirect:/index"; 
    }
    }
    
    

