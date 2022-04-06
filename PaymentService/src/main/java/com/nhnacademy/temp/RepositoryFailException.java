package com.nhnacademy.temp;

import java.io.IOException;

public class RepositoryFailException extends RuntimeException {
    public RepositoryFailException(String message, IOException e) {
        super(message);
    }
}
