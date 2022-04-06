package com.nhnacademy.paymentservice;

import com.nhnacademy.paymentservice.accounts.Account;

public class Bill {
    private int price;
    private Account account;

    public Bill(int price, Account account) {
        this.price = price;
        this.account = account;
    }

    public int getPrice() {
        return price;
    }

    public Account getAccount() {
        return account;
    }
}
