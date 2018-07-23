package com.epam.Nikolay_Samokhin.java.WebDriverBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebDriverSettingsMainPage {

    WebDriver driver;
    public MainPage mainPage;
    String propertyWebdriver = "webdriver.chrome.driver";
    String path = "D:/chromedriver/chromedriver.exe";
    String url = "https://passport.yandex.ru/auth?from=mail&origin=hostroot_homer_auth_L_ru&retpath=" +
        "https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fmail.yandex.ru%3Fnoretpath%3D1";
    String start = "Start";
    String stop = "Stop";

    @BeforeClass
    public void setUp() {

        System.setProperty(propertyWebdriver, path);
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        mainPage.getDriver().get(url);
        System.out.println(start);

    }


    @AfterClass
    public void close() {

        if (driver != null) driver.quit();
        System.out.println(stop);
    }
}