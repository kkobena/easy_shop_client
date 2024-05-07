package com.kobe.warehouse.easy_shop_client.http.request;

public class SaleQueryParams extends QueryParams {
  private String type;
  private boolean global = true;

  public String getType() {
    return type;
  }

  public SaleQueryParams setType(String type) {
    this.type = type;
    return this;
  }

  public boolean getGlobal() {
    return global;
  }

  public SaleQueryParams setGlobal(boolean global) {
    this.global = global;
    return this;
  }
}
