package com.epam.Nikolay_Samokhin.java.WebDriverBasic.users;

public class User {
    private String login;
    private String password;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static User createUser() {
        String fillLogin = "awesome.epam@yandex.ru";
        String fillPassword = "9339992acd";
        User user = new User(fillLogin, fillPassword);
        return user;
    }

}