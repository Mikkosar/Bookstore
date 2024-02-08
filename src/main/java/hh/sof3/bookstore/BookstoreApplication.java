package hh.sof3.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner books(BookRepository bookRepository) {
		return (args) -> {

			List<Book> books = new ArrayList<>();

			books.add(new Book("Tuhat loistavaa aurinkoa", "Khaled Hossein", 2009, "9789511236009", 19.40));
			books.add(new Book("2001 Avaruusseikkaulu", "Arthur C. Clarke", 1968, "9789520431396", 10.70));
			books.add(new Book("Piina", "Stephen King", 1983, "9789520405038", 17.10));
			books.add(new Book("Leijapoika", "Khaled Hossein", 2003, "9789511226222", 19.40));
		
			bookRepository.saveAll(books);

		};
	}

}
