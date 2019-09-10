package com.hungpham.ecommerce.controller;

import com.hungpham.ecommerce.exception.BusinessException;
import com.hungpham.ecommerce.exception.ErrorCode;
import com.hungpham.ecommerce.model.entity.Product;
import com.hungpham.ecommerce.service.impl.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        log.info("\n------- name:" + product.getName());
        Product saved = productService.create(product);
        return saved;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id) {
        Optional<Product> optionalProduct = productService.findById(id);
        optionalProduct.orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND_ERROR));
        return optionalProduct.get();
    }

    @GetMapping
    public Iterable<Product> find() {
        return productService.findAll();
    }
}
