package com.nokia.example.service;

import com.nokia.example.model.Person;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("baseService_underProxy")
public class BaseServiceHander implements BaseService{

    @Override
    @Cacheable(value = "person" , keyGenerator = "wiselyKeyGenerator")
    public String BaseInfo(Person person) {
        System.out.println("Invock BaseService:"+person.getName());
        return person.getName();
    }
}
