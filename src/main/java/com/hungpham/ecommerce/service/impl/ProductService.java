package com.hungpham.ecommerce.service.impl;

import com.hungpham.ecommerce.model.entity.Product;

import java.util.Optional;

public interface ProductService {
    Product create(Product product);
    Optional<Product> findById(Integer id);
    Iterable<Product> findAll();
}
