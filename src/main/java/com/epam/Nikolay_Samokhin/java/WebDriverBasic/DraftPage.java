package com.epam.Nikolay_Samokhin.java.WebDriverBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftPage {
    private final int STANDING_TIME = 10;
    WebDriver driver;

    public void getDriver(WebDriver driver) {
        this.driver = driver;

    }

    public void clickDraftButton() {
        String path = "//*[@class = 'mail-NestedList-Item-Name js-folders-item-name' and contains(text()," +
            "'Черновики')]";
        WebElement webElement = (new WebDriverWait(driver, STANDING_TIME))
            .until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        webElement.click();
    }

    public void clickCheckBoxDraftButton() {
        String path = "div.ns-view-container-desc>div";
        WebElement webElement = (new WebDriverWait(driver, STANDING_TIME))
            .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
        webElement.click();
    }


    public void clickDeleteDraftButton() {
        String path = "(.//div/descendant::span[2])[23]";
        WebElement webElement = (new WebDriverWait(driver, STANDING_TIME))
            .until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        webElement.click();
    }

    public void clickRefreshButton() {
        String path = "span.mail-ComposeButton-Refresh.js-left-col-toolbar-refresh.ns-action";
        WebElement webElement =driver.findElement(By.cssSelector(path));
        webElement.click();
    }

    public boolean checkRecieverWords(String words) {
        String path = " (//div/descendant::span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_sender " +
            "js-message-snippet-sender\"]/span)[1]";
        WebElement webElement = (new WebDriverWait(driver, STANDING_TIME))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            return words.equals("<" + webElement.getText() + ">");
    }

    public boolean checkThemeWords(String words) {

        String path = "(//*[@class=\"ns-view-container-desc mail-MessagesList js-messages-list\"]/div/descendant::" +
            "span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_subject\"])";
        WebElement webElement = (new WebDriverWait(driver, STANDING_TIME))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));

        return words.equals(webElement.getText());
    }

    public boolean checkBodyWords(String words) {

        String path = ".//span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_firstline js-message-" +
            "snippet-firstline\"]";
        WebElement webElement = (new WebDriverWait(driver, STANDING_TIME))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        return words.equals(webElement.getText());
    }


    public void clickButtonOnLogin() {
        String path = "[data-key= 'view=head-user']";
        WebElement webElement =driver.findElement(By.cssSelector(path));
        webElement.click();
    }


    public void clickExitMail() {
        String path = "[data-metric=\"Выйти из сервисов Яндекса\"]";
        WebElement webElement =driver.findElement(By.cssSelector(path));
        webElement.click();
    }

}