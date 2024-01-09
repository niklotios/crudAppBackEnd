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
                    "category with id " + categoryId + "does not exist");
        }
        categoryRepository.deleteById(categoryId);
    }

    public void updateCategoryName(Long categoryId, String newCategoryName) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setCategoryName(newCategoryName);
            categoryRepository.save(category);
        }else {
            throw new CategoryNotFoundException("Category not found with ID" + categoryId);
        }
    }

    public Long findCategoryIdByName(String categoryName) {
        Optional<Category> category = categoryRepository.findByCategoryName(categoryName);
        return category.map(Category::getCategoryId).orElse(null);
    }

    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName).orElse(null);
    }
}
