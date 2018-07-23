package com.epam.Nikolay_Samokhin.java.WebDriverBasic.data_provider;

import com.epam.Nikolay_Samokhin.java.WebDriverBasic.data_sources.DataSource;
import org.testng.annotations.DataProvider;

public class DataProviderEmail {

    @DataProvider(name = "wordsMail")
    public static Object[][] createStrings() {
        return  new DataSource().getDataSource();
        }
    }

