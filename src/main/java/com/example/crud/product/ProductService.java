package com.example.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.findByCategoryCategoryName(categoryName);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException(
                    "product with id " + productId + "does not exist"
            );
        }
        productRepository.deleteById(productId);
    }

    public void addNewProduct(Product product) {
        Optional<Product> productByProductName = productRepository.
                findProductsByProductName(product.getProductName());
        if(productByProductName.isPresent()){
            throw new IllegalStateException("Product already exists");
        }

        productRepository.save(product);
    }
}
