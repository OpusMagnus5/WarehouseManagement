package com.damian.bodzioch.warehouse.management.model;

public class User {
    private int id = 2;
    private String login;
    private String password;
    private static int idCounter = 2;

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User() {
        this.id = idCounter;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}