package com.hungpham.ecommerce.service.impl;

import com.hungpham.ecommerce.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product create(Product product);
    List<Product> findByName(String name);
}
