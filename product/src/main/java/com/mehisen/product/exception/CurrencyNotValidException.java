package com.mehisen.product.exception;

public class CurrencyNotValidException extends RuntimeException {
    public CurrencyNotValidException(String s) {
        super(s);
    }
}
