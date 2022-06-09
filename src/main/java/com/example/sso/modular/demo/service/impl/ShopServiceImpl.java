package com.example.sso.modular.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.sso.modular.demo.entity.DogTest;
import com.example.sso.modular.demo.service.ShopService;
import com.example.sso.modular.redis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author zhangxinyu
 * @date 2022/06/08 15:29
 **/
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private IRedisService iRedisService;
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public void save() {
        DogTest dogTest = new DogTest();
        dogTest.setId(123L);
        dogTest.setName("wangwang");
        redisTemplate.opsForValue().set("1", JSON.toJSONString(dogTest, SerializerFeature.WriteClassName));

    }

    @Override
    public DogTest getDog(String key) {
        key = "1";
        return JSON.parseObject(redisTemplate.opsForValue().get(key),DogTest.class);
    }
}
