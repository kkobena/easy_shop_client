package com.kobe.warehouse.easy_shop_client.view_model;

public enum NatureVente {
  COMPTANT("Comptant"),
  ASSURANCE("Assurance"),
  CARNET("Carnet");
  private final String value;

  NatureVente(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
