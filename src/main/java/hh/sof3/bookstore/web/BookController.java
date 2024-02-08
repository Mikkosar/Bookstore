package hh.sof3.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class BookController {

    //Returns welcome text
    //https://localhost:8080/index

    @GetMapping(value = "/index")
    public String bookStore() {
        return "index"; //index.html
    }
}
