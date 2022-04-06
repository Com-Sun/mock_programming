package com.nhnacademy.paymentservice.accounts;

public class LoginFailedException extends RuntimeException {
    public LoginFailedException() {
        super("Login Failed");
    }
}
