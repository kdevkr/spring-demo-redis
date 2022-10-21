package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringDemoRedisApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void pingTest() {
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        Assertions.assertNotNull(connectionFactory);
        RedisConnection redisConnection = RedisConnectionUtils.getConnection(connectionFactory);
        String pong = redisConnection.ping();
        RedisConnectionUtils.releaseConnection(redisConnection, connectionFactory);
        Assertions.assertEquals("PONG", pong);
    }

}
