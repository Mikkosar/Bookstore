package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
    public class BookController {

        @Autowired
        private BookRepository bookRepository;

        @Autowired
        private CategoryRepository categoryRepository;

        //Bookstores starting site, which has list of books.
        //http://localhost:8080/index

        @GetMapping(value = "/index")
        public String bookStore(Model model) {

            model.addAttribute("books", bookRepository.findAll());

            return "index"; //index.html
        }

        @GetMapping(value = "/add")
        public String addBook(Model model) {

            model.addAttribute("book", new Book());
            model.addAttribute("categories", categoryRepository.findAll());

            return "bookform"; // bookform.html
        }

        @PostMapping(value = "/save")
        public String saveBook(@ModelAttribute Book book) {
            
            if (book.getTitle() != null && !book.getTitle().isEmpty()){
                bookRepository.save(book);
            }
            return "redirect:/index";
        }

        @GetMapping(value = "/delete/{id}")
        @PreAuthorize("hasAuthority('ADMIN')")
        public String deleteBook(@PathVariable("id") Long Id, Model model){

            bookRepository.deleteById(Id);

            return "redirect:/index"; 
        }

        @GetMapping(value = "/edit/{id}")
        public String editBook(@PathVariable("id") Long Id, Model model) {
            
            model.addAttribute("book", bookRepository.findById(Id));
            
            return "editbook"; // editbook.html
        }

        @GetMapping(value = "/login")
        public String loginPage() {
            return "login"; // login.html
        }

        @GetMapping(value = "/logout")
        public String logoutPage(){
            return "redirect:/login?logout";
        }
        
        
    }
    
    

