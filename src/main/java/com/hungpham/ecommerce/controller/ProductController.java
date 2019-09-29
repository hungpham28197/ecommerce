package com.hungpham.ecommerce.controller;

import com.hungpham.ecommerce.model.entity.Product;
import com.hungpham.ecommerce.service.impl.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    private static final Logger log = LogManager.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/{name}")
    public List<Product> findById(@PathVariable String name) {
        List<Product> products = productService.findByName(name);
        return products;
    }
}
