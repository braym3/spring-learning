package com.qa.springlearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springlearning.domain.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat,Long> {      //JpaRepository does basic full crud for you

    // Custom method - find by name (Spring generates crud method for you - based on name)
    public List<Cat> findByName(String name);

}
