package com.hungpham.ecommerce.repository;

import com.hungpham.ecommerce.model.entity.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String>, JpaSpecificationExecutor<Product> {
}
