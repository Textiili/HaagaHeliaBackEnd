package hh.sof3.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categorylist")
    public String getCategories(Model model) {
        List<Category> categories =  (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories); 
        return "categorylist"; 
    }

    //Uusi lomake 
    @GetMapping("/newcategory")
    public String getNewCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        //^alustetaan tyhjä olio, jolle asetetaan arvot
        return "categoryform";
    }

    @GetMapping("/editcategory/{categoryid}")
    public String editCategory(@PathVariable("categoryid") Long categoryId, Model model) {
        model.addAttribute("category", categoryRepository.findById(categoryId));
        return "categoryform";
    }

    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }


    @GetMapping("/deletecategory/{categoryid}")
    public String deleteCategory(@PathVariable("categoryid") Long categoryId) {
        categoryRepository.deleteById(categoryId);
        return "redirect:/categorylist";
    }
}
