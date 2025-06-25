package com.docker.pages.FlightRegistration;

import com.docker.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationSuccessPage extends BasePage {
    private WebDriver driver;
    public RegistrationSuccessPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id="go-to-flights-search")
    private WebElement btn_FlightSearch;
    public void clickSearch(){
        btn_FlightSearch.click();
    }

    @Override
    public boolean onPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_FlightSearch));
        return btn_FlightSearch.isDisplayed();
    }
}
