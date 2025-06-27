package com.docker.pages.VendorPortal;

import com.docker.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashBoardPage extends BasePage {
    public DashBoardPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean onPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(text_MonthlyEarning));
        return text_MonthlyEarning.isDisplayed();
    }

    @FindBy(id = "monthly-earning")
    private WebElement text_MonthlyEarning;
    @FindBy(id = "annual-earning")
    private WebElement text_annualEarning;
    @FindBy(id = "profit-margin")
    private WebElement text_profitMargin;
    @FindBy(id = "available-inventory")
    private WebElement text_availableInventory;
    @FindBy(xpath = "//*[@type='search']")
    private WebElement feild_search;
    @FindBy(id="dataTable_info")
    private WebElement text_entries;
    @FindBy(xpath = "//*[contains(@class,'img-profile')]")
    private WebElement icon_profile;
    @FindBy(xpath = "//*[normalize-space(.)='Logout' and @class='dropdown-item']")
    private WebElement button_logout;
    @FindBy(xpath = "//*[@class='btn btn-primary' and .='Logout']")
    private WebElement modal_logout;
    public String monthlyEarning(){
        return text_MonthlyEarning.getText();
    }
    public String annualEarning(){
        return text_annualEarning.getText();
    }
    public String profitMargin(){
        return text_profitMargin.getText();
    }
    public String avaialableInventory(){
        return text_availableInventory.getText();
    }
    public String entries(){
        return text_entries.getText();
    }
    public void search(String search){
        feild_search.sendKeys(search);
    }
    public void logout(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",icon_profile);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",button_logout);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",modal_logout);
    }
}
