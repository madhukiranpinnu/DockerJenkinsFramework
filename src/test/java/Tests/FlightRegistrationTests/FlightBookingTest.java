package Tests.FlightRegistrationTests;

import com.docker.pages.FlightRegistration.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightBookingTest {
    WebDriver driver;
    String passanger;
    String price;
    @BeforeTest
    @Parameters({"passanger","price"})
    public void BeforeTest(String passanger,String price){
        this.passanger=passanger;
        this.price=price;
      driver=new ChromeDriver();
    }
    @AfterTest
    public void AfterTest(){
        driver.quit();
    }
    @Test
    public void Registration(){
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.getURl();
        Assert.assertTrue(registrationPage.onPage());
        registrationPage.nameDetails("Madhu","kiran");
        registrationPage.passwords("ghj@gmail.com","password");
        registrationPage.addAddress("mk street","mk city","500032");
        registrationPage.registerButton();
    }
    @Test(dependsOnMethods = "Registration")
    public void successRegistration(){
        RegistrationSuccessPage registrationSuccessPage=new RegistrationSuccessPage(driver);
        Assert.assertTrue(registrationSuccessPage.onPage());
        registrationSuccessPage.clickSearch();
    }
    @Test(dependsOnMethods = "successRegistration")
    public void searchFlight(){
        FlightSearchPage flightSearchPage=new FlightSearchPage(driver);
        Assert.assertTrue(flightSearchPage.onPage());
        flightSearchPage.FlightSearch(passanger);
    }
    @Test(dependsOnMethods = "searchFlight")
    public void selectFlights(){
        SelectFlightsPage selectFlightsPage=new SelectFlightsPage(driver);
        Assert.assertTrue(selectFlightsPage.onPage());
        selectFlightsPage.selectFlight();
    }
    @Test(dependsOnMethods = "selectFlights")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
        Assert.assertTrue(flightConfirmationPage.onPage());
        Assert.assertEquals(flightConfirmationPage.FlightPrice(),price);
    }
}
