package com.qa.springlearning.repo;

import com.qa.springlearning.domain.Cat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> { //JpaRepository does basic full crud for you
  // Custom method - find by name (Spring generates crud method for you - based on name)
  List<Cat> findByName(String name);
}
