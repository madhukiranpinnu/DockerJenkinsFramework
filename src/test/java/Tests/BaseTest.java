package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;
    @AfterTest
    public void AfterTest(){
        driver.quit();
    }
    @BeforeTest
    public void BeforeTest(){
        driver=new ChromeDriver();
    }
}
