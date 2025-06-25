package com.docker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    public BasePage(WebDriver driver){
        this.driver=driver;
        this.webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver,this);
    }
    public abstract boolean onPage();
}
