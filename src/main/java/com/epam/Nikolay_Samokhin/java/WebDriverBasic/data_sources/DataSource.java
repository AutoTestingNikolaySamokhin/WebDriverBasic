package com.epam.Nikolay_Samokhin.java.WebDriverBasic.data_sources;


public class DataSource {

    Object dataSource[][];

    public Object[][] getDataSource() {

        dataSource = new Object[][]{
            new Object[]{"<nikolaj_test_samoxin@mail.ru>", "tema", "Test test"},
            new Object[]{"<nikolaj_test_sin@mail.ru>", "Hello from Russia", "Test"},
            new Object[]{"<nikolaj_tst_sin@mail.r>", "Hello", "Test your"}
        };

        return dataSource;
    }
}

