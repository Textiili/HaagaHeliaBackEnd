package hh.sof3.bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByAuthorShouldReturnAuthor() {
        List<Book> books = bookRepository.findByAuthor("Yuval Noah Harari");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Yuval Noah Harari");
    }
    
    @Test 
    public void createNewBookTest() {
        Category category = categoryRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
    	Book book = new Book("Kuinka kirjoittaa uusi kirja", "Erkki Tiili", 2024, "008-002-000-000-7", 30.55f, category);
    	bookRepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

    @Test
    public void deleteBookTest() {
        bookRepository.deleteById(3L);
        assertThat(bookRepository.findById(3L)).isEmpty();
    }
}
