package utilities;

import com.github.dockerjava.api.model.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserUtil {

//   Mini-Task: CREATE A CLASS  SmartBearUtils
//   Create a method called loginToSmartBear
//   This method simply logs in to SmartBear when you call it.
//   Accepts WebDriver type as parameter

    public static void main(String[] args) {


    }

    public static WebDriver SmartBearUtils(WebDriver  driver){

        WebElement username= driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password= driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement loginBtn= driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginBtn.click();

        return driver;

    }

}
