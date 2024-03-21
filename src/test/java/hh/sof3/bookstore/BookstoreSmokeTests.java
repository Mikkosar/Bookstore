package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof3.bookstore.domain.UserRepository;
import hh.sof3.bookstore.web.BookController;
import hh.sof3.bookstore.web.BookControllerRest;
import hh.sof3.bookstore.web.CategoryController;

@SpringBootTest
public class BookstoreSmokeTests {

    //Tests for normal controllers

    @Autowired
    private BookController bookController;

        @Test
        public void bookContextLoads() throws Exception {
            assertThat(bookController).isNotNull();
        }

    @Autowired
    private CategoryController categoryController;

        @Test
        public void categoryContextLoads() throws Exception {
            assertThat(categoryController).isNotNull();
        }

    //Tests for REST controllers

    @Autowired
    private BookControllerRest bookControllerRest;
        
        @Test
        public void restContextLoads() throws Exception {
            assertThat(bookControllerRest).isNotNull();
        }

}   
