package com.example.sso.modular.demo.controller;

import com.example.sso.modular.demo.entity.DogTest;
import com.example.sso.modular.demo.service.ShopService;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangxinyu
 * @date 2022/06/08 15:31
 **/
@RestController
public class DogTestController {
    @Autowired
    private ShopService service;


    @RequestMapping("/test")
    public void Test(){

        service.save();
    }

    @RequestMapping("/test2")
    public DogTest GetDog(){
        return service.getDog("");
    }
}
