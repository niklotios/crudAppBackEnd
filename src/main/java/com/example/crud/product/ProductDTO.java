package com.example.crud.product;

public class ProductDTO {
    private String productName;
    private Integer productSerial;
    private Double price;
    private String categoryName;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
