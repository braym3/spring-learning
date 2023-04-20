package com.qa.springlearning.integration;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springlearning.domain.Cat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // will run the application normally to test it properly - makes sure ports not being used
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:cat-schema.sql", "classpath:cat-data.sql" }) // give it some SQL scripts in an array
public class CatIntegrationTest {

  @Autowired // dependency injeciton - moving one bean into another one
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper; // convert Java to JSON

  @Test // test create method
  void testCreate() throws Exception {
    // Create request
    Cat newCat = new Cat("Alan", true, false, 23.71, true);
    String newCatAsJson = this.mapper.writeValueAsString(newCat);
    RequestBuilder req = MockMvcRequestBuilders
      .post("/create")
      .content(newCatAsJson)
      .contentType(MediaType.APPLICATION_JSON); // URL, method, body & set content type to JSON in header

    // Create response checks
    ResultMatcher checkStatus = status().isCreated();
    Cat created = new Cat(2L, "Alan", true, false, 23.71, true);
    String createdAsJson = this.mapper.writeValueAsString(created);
    ResultMatcher checkBody = MockMvcResultMatchers
      .content()
      .json(createdAsJson);

    // Send the request and check status & body
    this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
  }

  @Test // test read by id method
  void testGet() throws Exception {
    // Create request
    RequestBuilder req = MockMvcRequestBuilders.get("/get/1"); // URL & method

    // Create response checks
    ResultMatcher checkStatus = status().isOk();
    Cat found = new Cat(1L, "Jeff", true, true, 27.28, true);
    String foundAsJson = this.mapper.writeValueAsString(found);
    ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJson);

    // Send the request and check status & body
    this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
  }

  @Test // test read all method
  void testGetAll() throws Exception {
    // Create request
    RequestBuilder req = MockMvcRequestBuilders.get("/getAll"); // URL & method

    // Create response checks
    ResultMatcher checkStatus = status().isOk();
    List<Cat> found = new ArrayList<Cat>();
    found.add(new Cat(1L, "Jeff", true, true, 27.28, true));
    String foundAsJson = this.mapper.writeValueAsString(found);
    ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJson);

    // Send the request and check status & body
    this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
  }

  @Test // test update by id method
  void testUpdate() throws Exception {
    // Create request
    RequestBuilder req = MockMvcRequestBuilders
      .patch("/update/1")
      .param("name", "Dorene")
      .param("hasWhiskers", "false")
      .param("evil", "false")
      .param("length", "43.21")
      .param("hasThumbs", "false"); // URL, method & query params

    // Create response checks
    ResultMatcher checkStatus = status().isOk();
    Cat found = new Cat(1L, "Dorene", false, false, 43.21, false);
    String foundAsJson = this.mapper.writeValueAsString(found);
    ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJson);

    // Send the request and check status & body
    this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
  }

  @Test // test remove by id method
  void testRemove() throws Exception {
    // Create request
    RequestBuilder req = MockMvcRequestBuilders.delete("/remove/1"); // URL & method

    // Create response checks
    ResultMatcher checkStatus = status().isOk();
    Cat found = new Cat(1L, "Jeff", true, true, 27.28, true);
    String foundAsJson = this.mapper.writeValueAsString(found);
    ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJson);

    // Send the request and check status & body
    this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
  }
}
