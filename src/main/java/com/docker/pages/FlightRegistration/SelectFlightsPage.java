package com.docker.pages.FlightRegistration;

import com.docker.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class SelectFlightsPage extends BasePage {
    public SelectFlightsPage(WebDriver driver){
        super(driver);
    }
    @Override
    public boolean onPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(text_Find));
        return text_Find.isDisplayed();
    }
    @FindBy(xpath = "//*[.='Select Flights']")
    private WebElement text_Find;
    @FindBy(name = "departure-flight")
    private List<WebElement> radiobutton_departure;
    @FindBy(name = "arrival-flight")
    private List<WebElement> radiobutton_arrival;
    Random random=new Random();
    int i=random.nextInt(9)+1;
    int j=random.nextInt(9)+1;
    public void selectFlight(){
        radiobutton_departure.get(i).click();
        radiobutton_arrival.get(j).click();
        text_Find.click();
    }
}
