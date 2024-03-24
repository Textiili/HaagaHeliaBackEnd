package hh.sof3.bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findCategoryShouldReturnCategory() {
        Optional<Category> shouldBeNonfiction = categoryRepository.findById(1L);
        assertThat(shouldBeNonfiction.get().getName()).isEqualTo("nonfiction");
    }
    
    @Test 
    public void createNewCategoryTest() {
        //New category in this case gets id value 5L assigned to it automatically
        Category category = new Category("manga");
    	categoryRepository.save(category);
    	assertThat(categoryRepository.findById(5L).get().getName()).isEqualTo("manga");
    }    

    @Test
    public void deleteCategoryTest() {
        categoryRepository.deleteById(5L);
        assertThat(categoryRepository.findById(5L)).isEmpty();
    }
}
