package com.hungpham.ecommerce.service.impl.impl;

import com.hungpham.ecommerce.model.entity.Product;
import com.hungpham.ecommerce.repository.cache.ProductRepositorySync;
import com.hungpham.ecommerce.service.impl.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
//
//    @Autowired
//    ProductRepository repository;
//
//    @Autowired
//    LoadingCache<Integer, Product> productCache;

    @Autowired
    RedisTemplate<String, Product> redisTemplate;

    @Autowired
    ProductRepositorySync repository;

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        logger.info("---> Used Key Redis: " + "ec_product_*_" + name);
        String keyPattern = "ec_product_*_" + name;
        List<Product> products = redisTemplate.keys(keyPattern).stream()
                .map(key -> redisTemplate.opsForValue().get(key))
                .filter(item -> item != null)
                .collect(Collectors.toList());
        return products;
    }
}
