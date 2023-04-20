package com.qa.springlearning.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springlearning.domain.Cat;
import com.qa.springlearning.service.CatService;

@RestController
public class CatController {

    private CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    // Create Cat method
    @PostMapping("/create")
    public ResponseEntity<Cat> createCat(@RequestBody Cat c){
        Cat created = this.service.createCat(c);
        return new ResponseEntity<>(created, HttpStatus.CREATED);      // return the last cat added with HTTP status code enum
    }

    @GetMapping("/getAll")
    public List<Cat> getAll(){
        return this.service.getAll();           // call the service and return the list of cats
    }
    
    @GetMapping("/get/{id}")
    public Cat get(@PathVariable int id){
        return this.service.get(id);
    }

    @DeleteMapping("/remove/{id}")
    public Cat remove(@PathVariable int id){
        return this.service.remove(id);
    }

    @PatchMapping("/update/{id}")
    public Cat update(@PathVariable int id, 
    @RequestParam(name = "name", required = false) String name,
    @RequestParam(name = "hasWhiskers", required = false) Boolean hasWhiskers,
    @RequestParam(name = "evil", required = false) Boolean evil,
    @RequestParam(name = "length", required = false) Double length,
    @RequestParam(name = "hasThumbs", required = false) Boolean hasThumbs){
        return this.service.update(id, name, hasWhiskers, evil, length, hasThumbs);
    }

    @GetMapping("/")
    public String greeting(){
        return "Hello, World!";
    }
    
}
