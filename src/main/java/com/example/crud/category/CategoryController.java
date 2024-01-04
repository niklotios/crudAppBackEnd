package com.example.crud.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category")
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    public void registerNewCategory(@RequestBody Category category){
        categoryService.addNewCategory(category);
    }

    @DeleteMapping(path = "{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);

    }

    @PutMapping(path = "{categoryId}", produces = "text/plain")
    public ResponseEntity<String> updateCategoryName(
            @PathVariable Long categoryId,
            @RequestBody String newCategoryName
    ){
        try{
            categoryService.updateCategoryName(categoryId,newCategoryName);
            return ResponseEntity.ok("Category updated");
        }catch (CategoryNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error updating category");
        }
    }

    @GetMapping("/findIdByName/{categoryName}")
    public Long findCategoryIdByName(@PathVariable String categoryName) {
        return categoryService.findCategoryIdByName(categoryName);
    }


}
