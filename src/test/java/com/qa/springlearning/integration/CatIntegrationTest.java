package com.qa.springlearning.integration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)     // will run the application normally to test it properly - makes sure ports not being used
@AutoConfigureMockMvc
public class CatIntegrationTest {
    
}
