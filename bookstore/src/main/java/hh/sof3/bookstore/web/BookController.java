package hh.sof3.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public String getBooks(Model model) {
        List<Book> books =  (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books); 
        // ^välitetään kirjalista templatelle model-olion avulla
        return "index"; 
    }

    //Uusi lomake 
    @GetMapping("/newbook")
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        //^alustetaan tyhjä olio, jolle asetetaan arvot
		return "bookform";
	}
    
    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bookRepository.findById(bookId));
        model.addAttribute("categories", categoryRepository.findAll());
        return "bookform";
    }

    @PostMapping("/savebook")
	public String saveBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
	}


    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return "redirect:/";
    }
}

