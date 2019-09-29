package com.hungpham.ecommerce;

import com.hungpham.ecommerce.model.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Product> redisTemplate;

    @Test
    public void getByScore(){
//        Set<Product> result = redisTemplate.opsForZSet().rangeByScore("ec_product", 2, 5);
        Set<Product> result = redisTemplate.opsForZSet().reverseRangeByScore("ec_product", Double.NEGATIVE_INFINITY, 4);
        System.out.println(result.iterator().next().getScore());
    }
}
