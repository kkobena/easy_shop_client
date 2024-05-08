package com.kobe.warehouse.easy_shop_client.http.error;

public class FieldError {
    private String field;
    private String message;

    public String getField() {
        return field;
    }

    public FieldError setField(String field) {
        this.field = field;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public FieldError setMessage(String message) {
        this.message = message;
        return this;
    }
}
