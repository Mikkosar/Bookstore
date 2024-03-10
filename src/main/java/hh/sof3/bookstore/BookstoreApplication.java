package hh.sof3.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;
import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner books(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {

			List<Book> books = new ArrayList<>();

			Category drama = new Category("drama");
			categoryRepository.save(drama);
			Category scifi = new Category("Scifi");
			categoryRepository.save(scifi);
			Category horror = new Category("Horror");
			categoryRepository.save(horror);


			books.add(new Book("Tuhat loistavaa aurinkoa", "Khaled Hossein", 2009, "9789511236009", 19.40, drama));
			books.add(new Book("2001 Avaruusseikkaulu", "Arthur C. Clarke", 1968, "9789520431396", 10.70, scifi));
			books.add(new Book("Piina", "Stephen King", 1983, "9789520405038", 17.10, horror));
			books.add(new Book("Leijapoika", "Khaled Hossein", 2003, "9789511226222", 19.40, drama));
		
			bookRepository.saveAll(books);

			User user1 = new User("user", "$2a$10$1n7rkAXRA7qj7wUewzMJo.izvELR1VwuuRFt2O5Phl85W6v4M0lIm", "user@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$ngu6FPEJMjjBdDtMQNx.o.8YUFK.zskewDwxHnj/a2kil1zYmo6YK", "admin@gmail.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}
}