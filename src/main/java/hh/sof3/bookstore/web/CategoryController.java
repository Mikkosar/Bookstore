package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

     @GetMapping(value = "/categorylist")
        public String categoryList(Model model) {

            model.addAttribute("categories", categoryRepository.findAll());

            return "categoryList"; //categoryList.html
        }


        @GetMapping(value = "/addcategory")
        public String addNewCategory(Model model) {

            model.addAttribute("category", new Category());

            return "categoryform"; // categoryform.html
        }
        

        @PostMapping(value = "/savecategory")
        public String saveCategory(@ModelAttribute Category category){
            
            categoryRepository.save(category);

            return "redirect:/categorylist";
        }
}
