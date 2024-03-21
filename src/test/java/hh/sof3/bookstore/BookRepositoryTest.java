package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.CategoryRepository;

@DataJpaTest
public class BookRepositoryTest {

    //Here we will test Bookrepos functionality (findByTitle, create, delete)

    @Autowired
    private BookRepository bookRepository;

        @Test
        public void findByTitleShouldReturnBook() {
            List<Book> books = bookRepository.findByTitle("Piina");

            assertThat(books).hasSize(1);
            assertThat(books.get(0).getAuthor()).isEqualTo("Stephen King");
        }

        @Test
        public void createBook() {
            Book book = new Book("Uusi kirja", "Uusi kirjailija", 2000, "123123123", 20.00, null);
            bookRepository.save(book);

            assertThat(book.getId()).isNotNull();
        }

        @Test
        public void deleteBook() {
            Book book = new Book("Uusi kirja", "Uusi kirjailija", 2000, "123123123", 20.00, null);
            bookRepository.save(book);
            bookRepository.delete(book);

            assertThat(bookRepository.findByTitle("Uusi kirja")).hasSize(0);
        }
    }