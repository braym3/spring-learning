package com.qa.springlearning.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.springlearning.domain.Cat;
import com.qa.springlearning.exception.CatNotFoundException;
import com.qa.springlearning.repo.CatRepo;

@Primary
@Service
public class CatServiceDB implements CatService {

    private CatRepo repo;

    public CatServiceDB(CatRepo repo) {
        this.repo = repo;
    }

    @Override
    public Cat createCat(Cat c) {
        return this.repo.save(c);
    }

    @Override
    public Cat get(int id) {
        return this.repo.findById((long)id).orElseThrow(CatNotFoundException::new);  // orElseThrows takes a supplier (functional interface) - so use lambda
    }

    @Override
    public List<Cat> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Cat remove(int id) {
        Cat removed = this.get(id);             // using the get method just made
        this.repo.deleteById((long)id);
        return removed;
    }

    @Override
    public Cat update(int id, String name, Boolean hasWhiskers, Boolean evil, Double length, Boolean hasThumbs) {
        Cat c = this.get(id);                   // get the cat by the id
        
        if(name != null) c.setName(name);       // set attributes if they're not null
        if(hasWhiskers != null) c.setHasWhiskers(hasWhiskers);
        if(evil != null) c.setEvil(evil);
        if(length != null) c.setLength(length);
        if(hasThumbs != null) c.setHasThumbs(hasThumbs);

        return this.repo.save(c);               // save the updated cat and return it
    }
    
}
