package com.qa.springlearning.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity     // Tells spring it's a table
public class Cat {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)    // makes it auto-increment
    private Long id;
    private String name;
    private boolean hasWhiskers;
    private boolean evil;
    private double length;
    private boolean hasThumbs;

    public Cat(){

    }

    public Cat(String name, boolean hasWhiskers, boolean evil, double length, boolean hasThumbs) {
        this.name = name;
        this.hasWhiskers = hasWhiskers;
        this.evil = evil;
        this.length = length;        
        this.hasThumbs = hasThumbs;
    }

    public Cat(Long id, String name, boolean hasWhiskers, boolean evil, double length, boolean hasThumbs) {
        this.id = id;
        this.name = name;
        this.hasWhiskers = hasWhiskers;
        this.evil = evil;
        this.length = length;        
        this.hasThumbs = hasThumbs;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isHasWhiskers() {
        return hasWhiskers;
    }
    public void setHasWhiskers(boolean hasWhiskers) {
        this.hasWhiskers = hasWhiskers;
    }
    public boolean isEvil() {
        return evil;
    }
    public void setEvil(boolean evil) {
        this.evil = evil;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }

    public boolean isHasThumbs() {
        return hasThumbs;
    }

    public void setHasThumbs(boolean hasThumbs) {
        this.hasThumbs = hasThumbs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
