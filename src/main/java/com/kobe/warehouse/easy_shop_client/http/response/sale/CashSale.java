package com.kobe.warehouse.easy_shop_client.http.response.sale;

import com.kobe.warehouse.easy_shop_client.view_model.customer.UninsuredCustomer;

public class CashSale extends Sale {
  private UninsuredCustomer customer;
  private Long customerId;

  public CashSale() {}


  public UninsuredCustomer getCustomer() {
    return customer;
  }


  public Long getCustomerId() {
    return customerId;
  }


  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public CashSale setCustomer(UninsuredCustomer customer) {
    this.customer = customer;
    return this;
  }


}
