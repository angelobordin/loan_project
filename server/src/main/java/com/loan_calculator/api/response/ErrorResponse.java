package com.loan_calculator.api.response;

public class ErrorResponse {
    private String message;
    private String error;
    private int status;

    // Construtores, getters e setters
    public ErrorResponse(String message, String error, int status) {
        this.message = message;
        this.error = error;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }
}
