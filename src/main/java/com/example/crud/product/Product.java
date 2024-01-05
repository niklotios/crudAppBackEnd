package com.example.crud.product;

import com.example.crud.category.Category;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "product_id")
    private Long productId;

    @Column(name = "product_name", unique = true, nullable = false)
    private String productName;

    @Column(name = "product_serial")
    private Integer productSerial;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "product_category", referencedColumnName = "category_name")
    private Category category;

    public Product() {
    }

    public Product(Long productId, String productName, Integer productSerial, Double price, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.productSerial = productSerial;
        this.price = price;
        this.category = category;
    }

    public Product(String productName, Integer productSerial, Double price, Category category) {
        this.productName = productName;
        this.productSerial = productSerial;
        this.price = price;
        this.category = category;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductSerial() {
        return productSerial;
    }

    public void setProductSerial(Integer productSerial) {
        this.productSerial = productSerial;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productSerial=" + productSerial +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
