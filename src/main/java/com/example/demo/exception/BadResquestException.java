package com.example.demo.exception;

public class BadResquestException extends RuntimeException {
    public BadResquestException(String messeage){
        super(messeage);
    }
}
