package com.epam.Nikolay_Samokhin.java.WebDriverBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.concurrent.TimeUnit;

public class MainPage {

    private final int STANDING_TIME = 20;
    private final int SLEEP = 1000;
    private WebDriver driver;
    private final String LOGIN_PATH =  "[name = login]";
    private final String PASSWORD_PATH = "[name = passwd]";
    private final String SUBMIT_PATH =  "[class= passport-Button-Text]";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(STANDING_TIME, TimeUnit.SECONDS);
    }


    @FindBy(css = LOGIN_PATH)
    WebElement userName;
    @FindBy(css = PASSWORD_PATH)
    WebElement password;
    @FindBy(css = SUBMIT_PATH)
    WebElement loginClickButton;


    public void waitElement() {
        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {

        return driver;
    }

    public void searchUserName(String query) {
        userName.clear();
        userName.sendKeys(query);

    }

    public void searchPassword(String query) {
        password.clear();
        password.sendKeys(query);
    }

    public void searchLoginClickButton() {
        loginClickButton.click();
    }


}