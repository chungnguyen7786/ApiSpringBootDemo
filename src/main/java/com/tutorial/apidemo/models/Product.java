package com.tutorial.apidemo.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

//POJO = Plain Object Java Object
@Entity  //Java hiểu đây là 1 thực thể => nó sẽ tìm đến khóa chính primary key
@Table(name="tblProduct")  //named for table
public class Product {
    //This is "primary key"
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) /* Dùng GenerateValue để tạo ra một strategy, trong đó sẽ  tạo ra 1 kiểu , tự động, => đây là trường id, là trường khóa chính, và tự sinh */
//    instead using auto generate, we can use sequence:
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )

    private Long id;

    @Column(nullable = false, unique = true, length = 300) //validate the column of table
    private String productName;
    private int year;
    private Double price;
    private String url;

    //default constructor
    public Product() {}

    //calculated field = transient -> the field that is not saved in DB, and can be calculated from other fields
    @Transient
    private int age; //age is calculated from year
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - year;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return year == product.year
                && age == product.age && Objects.equals(id, product.id)
                && Objects.equals(productName, product.productName) &&
                Objects.equals(price, product.price) && Objects.equals(url, product.url);
    }
}
