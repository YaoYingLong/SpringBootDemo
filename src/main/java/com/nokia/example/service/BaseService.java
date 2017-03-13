package com.nokia.example.service;

import com.nokia.example.model.Person;
import org.springframework.stereotype.Service;

@Service
public interface BaseService {

    public String BaseInfo(Person message);

}
