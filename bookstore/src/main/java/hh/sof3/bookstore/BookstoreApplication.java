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

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) { 
		return (args) -> {
			log.info("save a couple of categories");
			Category category1 = new Category("nonfiction");
			Category category2 = new Category("horror");
			categoryRepository.save(category1);
			categoryRepository.save(category2);

			log.info("save a couple of books");
			Book book1 = new Book("Homo Deus", "Yuval Noah Harari", 2015, "978-952-279-625-7", 25.50f);
			Book book2 = new Book("Hyvän historia", "Rutger Bregman", 2019, "978-952-279-625-7", 20.00f);
			bookRepository.save(book1);
			bookRepository.save(book2);	
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			log.info("fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
		};
	}
}
