package com.hungpham.ecommerce.service.impl.impl;

import com.hungpham.ecommerce.model.entity.Product;
import com.hungpham.ecommerce.repository.ProductRepository;
import com.hungpham.ecommerce.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }
}
