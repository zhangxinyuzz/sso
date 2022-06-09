package com.example.sso.modular.redis.service.impl;

import com.example.sso.modular.redis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxinyu
 * @date 2022/06/08 15:17
 **/
@Service
public class IRedisServiceImpl implements IRedisService {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void setValue(String key, Map<String, Object> value) {
        ValueOperations<String,Map<String,Object>> vo = redisTemplate.opsForValue();
        vo.set(key,value);
    }

    @Override
    public Object getValue(String key) {
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    @Override
    public void setValue(String key, String value) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
        redisTemplate.expire(key, 1, TimeUnit.HOURS); // 这里指的是1小时后失效
    }

    @Override
    public void setValue(String key, Object value) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
        redisTemplate.expire(key, 1, TimeUnit.HOURS); // 这里指的是1小时后失效
    }

    @Override
    public Object getMapValue(String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }
}
