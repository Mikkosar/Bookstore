package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositryTests {

    @Autowired
    private CategoryRepository categoryRepository;

        //Here we will test Categoryrepos functionality (findByTitle, create, delete)
    
        @Test
        public void findbyNameShouldRetrunCategory() {
            List<Category> categories = categoryRepository.findByName("drama");

            assertThat(categories).hasSize(1);
        }

        @Test
        public void createNewCategory() {
            Category category = new Category("New category");
            categoryRepository.save(category);

            assertThat(category.getCategoryId()).isNotNull();
        }

        @Test
        public void deleteCategory() {
            Category category = new Category("New category");
            categoryRepository.save(category);
            categoryRepository.delete(category);

            assertThat(categoryRepository.findByName("New category")).hasSize(0);
        }
}
