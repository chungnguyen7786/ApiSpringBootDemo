package com.tutorial.apidemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//POJO = Plain Object Java Object
@Entity  //Java hiểu đây là 1 thực thể => nó sẽ tìm đến khóa chính primary key
public class Product {
    //This is "primary key"
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) /* Dùng GenerateValue để tạo ra một strategy, trong đó sẽ  tạo ra 1 kiểu , tự động, => đây là trường id, là trường khóa chính, và tự sinh */
    private Long id;
    private String productName;
    private int year;
    private Double price;
    private String url;

    //default constructor
    public Product() {}

    public Product(String productName, int year, Double price, String url) {
        this.productName = productName;
        this.year = year;
        this.price = price;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }
}
