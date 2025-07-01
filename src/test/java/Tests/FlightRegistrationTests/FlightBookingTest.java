package Tests.FlightRegistrationTests;

import Tests.BaseTest;
import Tests.FlightRegistrationTests.model.FlightBookingData;
import Util.Config;
import Util.Constants;
import com.docker.pages.FlightRegistration.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Util.JsonUtil;

public class FlightBookingTest extends BaseTest {
    FlightBookingData flightBooking;
    @BeforeTest
    @Parameters({"flightBookingData"})
    public void BeforeTests(String flightBookingData){
     flightBooking= JsonUtil.getData(flightBookingData,FlightBookingData.class);
    }
    @Test
    public void Registration(){
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.getURl(Config.getProperty(Constants.FlightReservation_URL));
        Assert.assertTrue(registrationPage.onPage());
        registrationPage.nameDetails(flightBooking.firstName(),flightBooking.lastName());
        registrationPage.passwords(flightBooking.email(), flightBooking.password());
        registrationPage.addAddress(flightBooking.street(), flightBooking.city(), flightBooking.zip());
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
        flightSearchPage.FlightSearch(flightBooking.passengersCount());
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
        Assert.assertEquals(flightConfirmationPage.FlightPrice(),flightBooking.expectedPrice());
    }
}
