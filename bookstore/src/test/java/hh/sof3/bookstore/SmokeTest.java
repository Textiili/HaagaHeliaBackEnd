package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import hh.sof3.bookstore.web.BookController;
import hh.sof3.bookstore.web.BookRestController;
import hh.sof3.bookstore.web.CategoryController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SmokeTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BookController bookController;

    @Autowired
    private BookRestController bookRestController;

    @Autowired
    private CategoryController categoryController;

    @Test
    public void indexPageLoads() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
        .contains("Please sign in");
    }

    @Test
    public void bookControllerNotNull() {
        assertThat(bookController).isNotNull();
    }

    @Test
    public void bookRestControllerNotNull() {
        assertThat(bookRestController).isNotNull();
    }

    @Test
    public void categoryControllerNotNull() {
        assertThat(categoryController).isNotNull();
    }
}

