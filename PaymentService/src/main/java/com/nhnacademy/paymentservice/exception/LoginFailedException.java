package com.nhnacademy.paymentservice.exception;

public class LoginFailedException extends RuntimeException {
    public LoginFailedException() {
        super("Login Failed");
    }
}
