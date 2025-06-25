package com.docker.pages.FlightRegistration;

import com.docker.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class FlightConfirmationPage extends BasePage {
    private static final Logger log= LoggerFactory.getLogger(FlightConfirmationPage.class);
    @Override
    public boolean onPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(text_Price));
        return text_Price.isDisplayed();
    }
    public FlightConfirmationPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "(//form//p)[3]")
    private WebElement text_Price;
    public String FlightPrice(){
        return text_Price.getText();
    }
}

