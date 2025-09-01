package com.example.jpaproject.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    // Default constructor
    public Category() {
    }

    // Constructor with all fields except id and products
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Helper method to add a product
    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }

    // Helper method to remove a product
    public void removeProduct(Product product) {
        products.remove(product);
        product.setCategory(null);
    }
}