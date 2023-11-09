package com.example.crud.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void addNewCategory(Category category) {
        System.out.println(category);
        Optional<Category> categoryByCategoryName = categoryRepository.
                findCategoriesByCategoryName(category.getCategoryName());
        if (categoryByCategoryName.isPresent()){
            throw new IllegalStateException("category already exists!");
        }
        //categoryRepository.findCategoriesByCategoryName(category.getCategoryName());
        categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        boolean exists = categoryRepository.existsById(categoryId);
        if (!exists){
            throw new IllegalStateException(
                    "student with id " + categoryId + "does not exist");
        }
        categoryRepository.deleteById(categoryId);
    }
}
