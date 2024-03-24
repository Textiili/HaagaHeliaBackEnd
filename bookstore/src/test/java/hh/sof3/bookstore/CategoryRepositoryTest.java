package hh.sof3.bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findCategoryByNameTest() {
        
        Category category = categoryRepository.findByName("nonfiction");
        assertThat(category.getName()).isEqualTo("nonfiction");
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
