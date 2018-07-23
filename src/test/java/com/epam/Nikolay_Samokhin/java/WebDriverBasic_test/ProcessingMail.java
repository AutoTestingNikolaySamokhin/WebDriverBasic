package com.epam.Nikolay_Samokhin.java.WebDriverBasic_test;


import com.epam.Nikolay_Samokhin.java.WebDriverBasic.DraftPage;
import com.epam.Nikolay_Samokhin.java.WebDriverBasic.PageFillParameters;
import com.epam.Nikolay_Samokhin.java.WebDriverBasic.users.User;
import com.epam.Nikolay_Samokhin.java.WebDriverBasic.WebDriverSettingsMainPage;
import com.epam.Nikolay_Samokhin.java.WebDriverBasic.data_provider.DataProviderEmail;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProcessingMail extends WebDriverSettingsMainPage {

    User user = User.createUser();
    PageFillParameters pageFillParameters = new PageFillParameters();
    DraftPage draftPage = new DraftPage();

    @Test(groups = "login page", priority = 3)
    private void inputLoginPage() {
        mainPage.searchUserName(user.getLogin());

    }

    @Test(dependsOnMethods = "inputLoginPage", groups = "login page", priority = 2)
    private void inputPasswordPage() {
        mainPage.searchPassword(user.getPassword());

    }

    @Test(dependsOnMethods = "inputPasswordPage", groups = "login page", priority = 1)
    private void checkButtonMainPage() {

        mainPage.searchLoginClickButton();
        pageFillParameters.getDriver(mainPage.getDriver());

    }


    @Test(dependsOnGroups = "login page", dataProvider = "wordsMail", dataProviderClass = DataProviderEmail.class)
    private void checkWordsMail(String wordsReciever, String wordsTheme, String wordsBody) {

        draftPage.getDriver(mainPage.getDriver());
        pageFillParameters.clickButtonWrite();
        pageFillParameters.writeWordsMail(wordsReciever);
        pageFillParameters.writeWordsTheme(wordsTheme);
        pageFillParameters.writeWordsBody(wordsBody);
        pageFillParameters.clickDraft();
        pageFillParameters.clickSaveDraft();
        draftPage.clickDraftButton();
        mainPage.waitElement();
        draftPage.clickRefreshButton();
        mainPage.waitElement();
        draftPage.clickRefreshButton();
        mainPage.waitElement();
        Assert.assertTrue(draftPage.checkRecieverWords(wordsReciever));
        Assert.assertTrue(draftPage.checkThemeWords(wordsTheme));
        Assert.assertTrue(draftPage.checkBodyWords(wordsBody));
        draftPage.clickRefreshButton();
        mainPage.waitElement();
        draftPage.clickCheckBoxDraftButton();
        draftPage.clickDeleteDraftButton();
    }

    @Test(dependsOnMethods = "checkWordsMail")
    public void exitMail() {

        draftPage.clickButtonOnLogin();
        draftPage.clickExitMail();
    }
}