package com.rpajdak.excercise;

public class NoCurrencyException extends Throwable {
    public NoCurrencyException(String currency) {
    }

    public String NoCurrencyException(String currency) {
        return String.format("There is no %s currency", currency);
    }
    
}
