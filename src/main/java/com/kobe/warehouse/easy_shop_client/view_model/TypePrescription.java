package com.kobe.warehouse.easy_shop_client.view_model;

public enum TypePrescription {
    PRESCRIPTION("Prescription"), CONSEIL("Conseil"), DEPOT("Dépôt");
    private final String value;

    public String getValue() {
        return value;
    }

    TypePrescription(String value) {
        this.value = value;
    }
}
