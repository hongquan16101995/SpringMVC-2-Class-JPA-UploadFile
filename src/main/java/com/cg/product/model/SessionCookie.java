package com.cg.product.model;

public class SessionCookie {
    private String username;
    private String password;
    private int counter = 0;

    public SessionCookie() {
    }

    public SessionCookie(String username, String password, int counter) {
        this.username = username;
        this.password = password;
        this.counter = counter;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void increment() {
        this.counter++;
    }
}
