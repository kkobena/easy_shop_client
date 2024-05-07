package com.kobe.warehouse.easy_shop_client.http.response.sale;

import com.kobe.warehouse.easy_shop_client.view_model.customer.AssuredCustomer;



public class ThirdPartySale extends Sale {
 private AssuredCustomer customer;
 private Long customerId;
  public AssuredCustomer getCustomer() {
    return customer;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public ThirdPartySale setCustomer(AssuredCustomer customer) {
    this.customer = customer;
    return this;
  }
}
