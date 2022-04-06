package com.nhnacademy.paymentservice.accounts;

public class Account {
    private long id;
    private String name;
    private String password;
    private int money;
    private int point = 0;

    public Account(String name, String password, long id, int money) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.money = money;

    }

    public String getName() {
        return name;
    }

    public long getId() {
        return this.id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void plusPoint(int point) {
        this.point += point;
    }
}
