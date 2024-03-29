package hh.sof3.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) { 
		return (args) -> {
			log.info("save a couple of categories");
			Category category1 = new Category("nonfiction");
			Category category2 = new Category("horror");
			Category category3 = new Category("scifi");
			Category category4 = new Category("romance");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);

			log.info("save a couple of books");
			Book book1 = new Book("Homo Deus", "Yuval Noah Harari", 2015, "978-952-279-625-7", 25.50f, category1);
			Book book2 = new Book("Hyvän historia", "Rutger Bregman", 2019, "978-031-641-852-2", 20.00f, category1);
			bookRepository.save(book1);
			bookRepository.save(book2);	

			User user1 = new User("user", "$2a$10$tN1dezKHj4ttNZjmzrC.f.h774ee12b4pDUmxbYStlEiypsma5wQy", "USER");
			User user2 = new User("admin", "$2a$10$.pn3kvLgvho5P6AJRSDrbOTMz9FB4.2a.Feh/B/L2gcUnOL6Iu4p2", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
