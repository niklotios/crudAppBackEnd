package com.example.crud.product;

import com.example.crud.category.Category;
import com.example.crud.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    private final CategoryService categoryService;
    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService){
        this.productService=productService;
        this.categoryService=categoryService;
    }

    @GetMapping("/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName){
        return productService.getProductsByCategory(categoryName);
    }

    @DeleteMapping(path="{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) {
        // Validate productDTO and perform necessary checks

        // Retrieve the category by name
        Category category = categoryService.getCategoryByName(productDTO.getCategoryName());

        if (category == null) {
            return new ResponseEntity<>("Category not found", HttpStatus.BAD_REQUEST);
        }

        // Create a new Product entity and set its properties
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductSerial(productDTO.getProductSerial());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        // Save the product
        productService.addProduct(product);

        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }
}




