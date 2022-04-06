package com.nhnacademy.paymentservice;

public class NotFoundAccountException extends RuntimeException {
    public NotFoundAccountException(String message) {
        super(message);
    }
}
