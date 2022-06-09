package com.example.sso.modular.demo.service;

import com.example.sso.modular.demo.entity.DogTest;

public interface ShopService {
    void save();
    DogTest getDog(String key);
}
