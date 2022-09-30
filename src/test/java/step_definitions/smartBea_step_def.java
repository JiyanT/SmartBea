package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class smartBea_step_def {
    WebDriver driver;
       @Given("User is on login Page")
        public void user_is_on_login_page () {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        @When("User enter the username and password")
        public void user_enter_the_username_and_password () {
         driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

            WebElement username= driver.findElement(By.id("ctl00_MainContent_username"));
            username.sendKeys("Tester");

            WebElement password= driver.findElement(By.id("ctl00_MainContent_password"));
            password.sendKeys("test");

        }
        @When("User click the Login button")
        public void user_click_the_login_button () {

           WebElement loginBtn= driver.findElement(By.id("ctl00_MainContent_login_button"));
           loginBtn.click();
        }
        @Then("User count and print the list of names")
        public void user_count_and_print_the_list_of_names () {
            List<WebElement> names = driver.findElements(By.xpath
                    ("//table[@id='ctl00_MainContent_orderGrid']//tbody//tr//td[2]"));

          //  System.out.println(names);

            String[] expectedName= new String[]{"Paul Brown", "Mark Smith", "Steve Johns", "Charles Dodgeson",
                    "Susan McLaren", "Bob Feather", "Samuel Clemens", "Clare Jefferson"};

            for (int i=0;  i<names.size(); i++){

                Assert.assertTrue(expectedName[i].contains(names.get(i).getText()));
            }

            System.out.println(names.size());

            Assert.assertEquals(names.size(), 8);





        }
    }
