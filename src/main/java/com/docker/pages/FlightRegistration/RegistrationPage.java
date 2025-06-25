package com.docker.pages.FlightRegistration;

import com.docker.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id="firstName")
    private WebElement textField_firstName;
    @FindBy(id="lastName")
    private WebElement textField_LastName;
    @FindBy(id="email")
    private WebElement textField_email;
    @FindBy(id="password")
    private WebElement textField_Password;
    @FindBy(name = "street")
    private WebElement textField_Street;
    @FindBy(name = "city")
    private WebElement textFeild_city;
    @FindBy(name = "zip")
    private WebElement textField_zip;
    @FindBy(id="register-btn")
    private WebElement button_register;
    public void nameDetails(String firstName,String lastName){
        textField_firstName.sendKeys(firstName);
        textField_LastName.sendKeys(lastName);
    }
    public void passwords(String email,String password){
        textField_Password.sendKeys(password);
        textField_email.sendKeys(email);
    }
    public void addAddress(String street,String city,String zip){
        textField_Street.sendKeys(street);
        textFeild_city.sendKeys(city);
        textField_zip.sendKeys(zip);
    }
    public void registerButton(){
        button_register.click();
    }
    public void getURl(){
        driver.get("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        driver.manage().window().maximize();
    }

    @Override
    public boolean onPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(this.textField_firstName));
        return this.textField_firstName.isDisplayed();
    }
}
