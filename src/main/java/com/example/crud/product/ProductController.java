package com.example.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){this.productService=productService;}

    @GetMapping("/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName){
        return productService.getProductsByCategory(categoryName);
    }

    @DeleteMapping(path="{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product) {productService.addNewProduct(product);}



}
