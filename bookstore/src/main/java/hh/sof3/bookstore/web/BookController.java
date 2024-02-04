package hh.sof3.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3.bookstore.domain.Book;

@Controller
public class BookController {

    private List<Book> friends = new ArrayList<>();

    @GetMapping("")
    public String getBooks(Model model) {
        return "index"; 
    }
}

