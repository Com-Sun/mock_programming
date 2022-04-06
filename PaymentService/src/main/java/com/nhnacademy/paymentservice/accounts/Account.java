package com.nhnacademy.paymentservice.accounts;

public class Account {
    private long id;
    private String name;
    private String password;

    public Account(String name, String password, long id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
}
