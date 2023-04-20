package com.qa.springlearning.service;

import java.util.List;

import com.qa.springlearning.domain.Cat;

public interface CatService {
    
    Cat createCat(Cat c);

    Cat get(int id);

    List<Cat> getAll();

    Cat remove(int id);

    Cat update(int id, String name, Boolean hasWhiskers, Boolean evil, Double length, Boolean hasThumbs);
    
}
