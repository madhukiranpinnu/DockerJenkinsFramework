package com.docker.pages.VendorPortal;

import com.docker.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean onPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(text_Field_Username));
        return text_Field_Username.isDisplayed();
    }
    @FindBy(id = "username")
    private WebElement text_Field_Username;
    @FindBy(id = "password")
    private WebElement textField_Password;
    @FindBy(id="login")
    private WebElement btn_login;
    public void goTo(){
        driver.get("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
    }
    public void Credentials(String username,String password){
        textField_Password.sendKeys(password);
        text_Field_Username.sendKeys(username);
        btn_login.click();
    }
}
