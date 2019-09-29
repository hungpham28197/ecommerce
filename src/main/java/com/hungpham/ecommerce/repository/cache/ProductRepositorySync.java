package com.hungpham.ecommerce.repository.cache;

import com.hungpham.ecommerce.event.Command;
import com.hungpham.ecommerce.event.CommandEventProducer;
import com.hungpham.ecommerce.event.EventCommandHandler;
import com.hungpham.ecommerce.model.entity.Product;
import com.hungpham.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class ProductRepositorySync implements RepositorySync<Product, Integer> {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommandEventProducer commandEventProducer;

    @Autowired
    private RedisTemplate<String, Product> redisTemplate;

    @Override
    public <S extends Product> S save(S var1) {
        CompletableFuture.supplyAsync(() -> {
            var1.setId(UUID.randomUUID().toString());
//            ValueOperations<String, Product> values = redisTemplate.opsForValue();
//            values.set("ec_product_" + var1.getId() + "_" + var1.getName(), var1);
            redisTemplate.opsForZSet().add("ec_product", var1, var1.getScore());
            return var1;
        }).thenAccept(saved -> {
            Command<Product, ProductRepository> command = new Command<>();
            command.setType(EventCommandHandler.SAVE);
            command.setBody(saved);
            command.setPersistent(productRepository);
            commandEventProducer.onData(command);
        });
        return var1;
    }

    @Override
    public void delete(Product var1) {

    }
}
