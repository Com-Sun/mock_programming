package com.nhnacademy.paymentservice.exception;

public class paymentFailedException extends RuntimeException{
    public paymentFailedException(String message) {
        super(message);
    }
}
