package com.example.sso.modular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

@Configuration //当前类为配置类
public class RedisConfig {
    @Resource
    RedisConnectionFactory redisConnectionFactory;
    @Bean //redisTemplate注入到Spring容器
    public RedisTemplate<String,String> redisTemplate(){
        RedisTemplate<String,String> redisTemplate=new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //key序列化
        redisTemplate.setKeySerializer(redisSerializer);
        //value序列化
        redisTemplate.setValueSerializer(redisSerializer);
        //value hashmap序列化
        redisTemplate.setHashKeySerializer(redisSerializer);
        //key hashmap序列化
        redisTemplate.setHashValueSerializer(redisSerializer);
        return redisTemplate;
    }
}