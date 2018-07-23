package com.epam.Nikolay_Samokhin.java.WebDriverBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFillParameters {
    WebDriver driver;
    private final int STANDING_TIME = 10;

    public void getDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void writeWordsMail(String words) {
        String path = "//*[@class=\"js-compose-field mail-Bubbles\"]";
        WebElement webElement = (new WebDriverWait(driver, STANDING_TIME))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        webElement.clear();
        webElement.sendKeys(words);
    }

    public void writeWordsBody(String words) {
        String path = "//*[@class=\"cke_contents cke_reset\"]/div";
        WebElement webElement = (new WebDriverWait(driver, STANDING_TIME))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        webElement.clear();
        webElement.sendKeys(words);

    }

    public void writeWordsTheme(String words) {
        String path = "//*[@class=\"mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev\"]";
        WebElement webElement = (new WebDriverWait(driver, STANDING_TIME))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        webElement.clear();
        webElement.sendKeys(words);

    }

    public void clickDraft() {
        WebElement webElement = driver.findElement(By.xpath("//*[@class=\"mail-NestedList-Item-Name " +
            "js-folders-item-name\"]"));
        webElement.click();

    }

    public void clickSaveDraft() {
        String path = "//*[contains(text(),'Сохранить и перейти')]";
        WebElement webElement = driver.findElement(By.xpath(path));
        webElement.click();
    }

    public void clickButtonWrite() {
        String path = "//*[@class=\"mail-ComposeButton-Text\"]";
        WebElement webElement = (new WebDriverWait(driver, STANDING_TIME)
            .until(ExpectedConditions.elementToBeClickable(By.xpath(path))));
        webElement.click();

    }


}
