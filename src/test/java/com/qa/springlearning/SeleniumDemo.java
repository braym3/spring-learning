package com.qa.springlearning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumDemo {

  private WebDriver driver; // a chrome window - close & reopen after every test

  @BeforeEach // before each test - set the chrome window up
  void init() {
    ChromeOptions options = new ChromeOptions(); // sets certain flags - fixes bug
    options.addArguments("--remote-allow-origins=*"); // allows it to access the devtools (not great fix but works)

    this.driver = new ChromeDriver(options); // create new chrome driver (new window) & passes options to the driver
    this.driver.manage().window().maximize(); // maximises it - make sure you can click on everything w/o scrolling
  }

  @Test
  void turtleTest() {
    this.driver.get("https://www.bbc.co.uk/search"); // re-directs browser to this address

    WebElement search =
      this.driver.findElement(By.cssSelector("#search-input")); // find the search bar using selector
    search.sendKeys("turtle"); // type in 'turtle'
    search.sendKeys(Keys.ENTER); // press enter

    WebElement result =
      this.driver.findElement(
          By.cssSelector(
            "#main-content > div.ssrcss-1v7bxtk-StyledContainer.enjd40x0 > div > div > ul > li:nth-child(1) > div > div > div.ssrcss-tq7xfh-PromoContent.e1f5wbog8 > div.ssrcss-1f3bvyz-Stack.e1y4nx260 > a"
          )
        );

    assertEquals("The Turtle Dove Pilgrimage", result.getText());
  }

  @Test
  void testPenguin() throws InterruptedException {
    this.driver.get("https://www.bing.com/?scope=web&cc=GB"); // go to bing search page

    Thread.sleep(3000); // make it wait for page to load

    WebElement search = this.driver.findElement(By.cssSelector("#sb_form_q")); // find search bar element
    search.sendKeys("penguin");
    search.sendKeys(Keys.ENTER);

    Thread.sleep(3000); // make it wait for page to load

    WebElement result =
      this.driver.findElement(
          By.cssSelector(
            "#b_results > li.b_algo.b_vtl_deeplinks > div.b_title > h2 > a"
          )
        ); // find first result

    assertEquals("Penguin Books UK | Official Website", result.getText());
  }

  @AfterEach // after each test - tear the chrome window down
  void tearDown() {
    this.driver.close();
  }
}
