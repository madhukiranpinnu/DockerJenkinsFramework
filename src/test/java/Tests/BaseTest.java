package Tests;

import Util.Config;
import Util.Constants;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    @BeforeSuite
    public void BeforeSuite(){
        Config.initializeProperties();
    }
    @AfterTest
    public void AfterTest(){
        driver.quit();
    }
    @BeforeTest
    public void BeforeTest() throws MalformedURLException {
        driver = Config.getProperty(Constants.GRID_STATUS).equalsIgnoreCase("true") ? remoteDriver() : localDriver();
    }
    public WebDriver localDriver(){
        return Config.getProperty(Constants.BROWSER).equalsIgnoreCase(Constants.CHROME) ?  new ChromeDriver(): new FirefoxDriver();
    }
    public WebDriver remoteDriver() throws MalformedURLException {
        Capabilities capabilities=Config.getProperty(Constants.BROWSER).equalsIgnoreCase(Constants.CHROME)?new ChromeOptions():new FirefoxOptions();
        String gridUrl= String.format(Config.getProperty(Constants.GRID_URL),Config.getProperty(Constants.HOST));
        return new RemoteWebDriver(new URL(gridUrl),capabilities);
    }
    //To see execution in grid added
    @AfterMethod
    public void Sleep(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }
}
