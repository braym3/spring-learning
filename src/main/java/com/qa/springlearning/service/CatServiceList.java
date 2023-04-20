package com.qa.springlearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springlearning.domain.Cat;

@Service
public class CatServiceList implements CatService {

    private List<Cat> cats = new ArrayList<>();

    @Override
    public Cat createCat(Cat c) {
        this.cats.add(c);                       // add cat to list
        return this.cats.get(cats.size()-1);    // return the created cat (last cat in the list)
    }

    @Override
    public Cat get(int id) {
        return this.cats.get(id);               // return cat from the list, using the id as index
    }

    @Override
    public List<Cat> getAll() {
        return this.cats;                       // return cat list
    }

    @Override
    public Cat remove(int id) {
        return this.cats.remove(id);            // remove the cat from the list and return the cat just removed
    }

    @Override
    public Cat update(int id, String name, Boolean hasWhiskers, Boolean evil, Double length, Boolean hasThumbs) {
        Cat c = this.cats.get(id);              // get the cat from the list using the id as index

        if(name != null) c.setName(name);       // set attributes if they were passed as param
        if(hasWhiskers != null) c.setHasWhiskers(hasWhiskers);
        if(evil != null) c.setEvil(evil);
        if(length != null) c.setLength(length);
        if(hasThumbs != null) c.setHasThumbs(hasThumbs);

        return c;                               // return updated cat
    }
    
}
