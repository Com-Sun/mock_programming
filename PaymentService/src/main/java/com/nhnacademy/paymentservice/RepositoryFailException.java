package com.nhnacademy.paymentservice;

import java.io.IOException;

public class RepositoryFailException extends RuntimeException {
    public RepositoryFailException(String message, IOException e) {
        super(message);
    }
}
