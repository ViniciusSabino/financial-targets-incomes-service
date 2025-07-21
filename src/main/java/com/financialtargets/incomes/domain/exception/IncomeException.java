package com.financialtargets.incomes.domain.exception;

import org.springframework.http.HttpStatus;

public class IncomeException extends Exception {
    public HttpStatus status;

    public IncomeException(String message, HttpStatus status) {
        super(message);

        this.status = status;
    }
}
