package com.qa.springlearning.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.qa.springlearning.domain.Cat;
import com.qa.springlearning.repo.CatRepo;
import com.qa.springlearning.service.CatService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // will run the application normally to test it properly - makes sure ports not being used
public class CatServiceDBTest {

  @Autowired // injects a bean into a bean
  private CatService service;

  @MockBean // make a mock repo
  private CatRepo repo;

  @Test
  void testCreate() {
    Cat newCat = new Cat("Kitty Minaj", true, true, 20.32, false);
    Cat created = new Cat(2L, "Kitty Minaj", true, true, 20.32, false);

    Mockito.when(this.repo.save(newCat)).thenReturn(created);

    assertEquals(created, this.service.createCat(newCat));
  }

  @Test
  void testGet() {
    int id = 1;
    Cat c = new Cat(1L, "Catrick Swayze", true, false, 27.28, true);

    Mockito.when(this.repo.findById((long) id)).thenReturn(Optional.of(c));

    assertEquals(c, this.service.get(id));
  }

  @Test
  void testGetAll() {
    List<Cat> cats = new ArrayList<Cat>();
    cats.add(new Cat(1L, "Pablo Picatso", true, true, 20.34, true));

    Mockito.when(this.repo.findAll()).thenReturn(cats);

    assertEquals(cats, this.service.getAll());
  }

  @Test
  void testUpdate() {
    int id = 1;
    Cat existing = new Cat((long) id, "Hairy Potter", true, true, 20.32, false);
    Cat updated = new Cat((long) id, "Uma Furman", true, true, 38.12, true);

    Mockito
      .when(this.repo.findById((long) id))
      .thenReturn(Optional.of(existing)); // Make an optional cat (if not equal to null)
    Mockito.when(this.repo.save(updated)).thenReturn(updated);

    assertEquals(
      updated,
      this.service.update(
          id,
          updated.getName(),
          updated.isHasWhiskers(),
          updated.isEvil(),
          updated.getLength(),
          updated.isHasThumbs()
        )
    );
  }

  @Test
  void testRemove() {
    int id = 1;
    Cat c = new Cat(1L, "David Meowie", true, false, 27.28, true);

    Mockito.when(this.repo.findById((long) id)).thenReturn(Optional.of(c)); // Make an optional cat (if not equal to null)

    assertEquals(c, this.service.get(id));
  }
}
