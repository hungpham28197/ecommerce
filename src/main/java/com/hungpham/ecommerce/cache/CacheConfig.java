package com.hungpham.ecommerce.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.hungpham.ecommerce.model.entity.Product;
import com.hungpham.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

//@Configuration
public class CacheConfig {
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Bean
//    LoadingCache<Integer, Product> productCache() {
//        return Caffeine.newBuilder()
//                .maximumSize(10_000)
//                .expireAfterWrite(5, TimeUnit.MINUTES)
//                .refreshAfterWrite(1, TimeUnit.MINUTES)
//                .build(key -> productRepository.findById(key).get());
//    }
}
