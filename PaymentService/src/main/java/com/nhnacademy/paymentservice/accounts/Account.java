package com.nhnacademy.paymentservice.accounts;

public class Account {
    private int id;
    private String name;
    private String password;

    public Account(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public Long getId() {
    }
}
