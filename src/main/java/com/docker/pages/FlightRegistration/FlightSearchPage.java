package com.docker.pages.FlightRegistration;

import com.docker.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends BasePage {
    public FlightSearchPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean onPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(button_SearchResults));
        return button_SearchResults.isDisplayed();
    }

    @FindBy(id="oneway")
    private WebElement radioButton_OneWay;
    @FindBy(id="passengers")
    private WebElement dropDown_Passengers;
    @FindBy(id = "search-flights")
    private WebElement button_SearchResults;
    Select select=new Select(dropDown_Passengers);
    public void FlightSearch(String Passengers){
        radioButton_OneWay.click();
        select.deselectByValue(Passengers);
        button_SearchResults.click();
    }
}
