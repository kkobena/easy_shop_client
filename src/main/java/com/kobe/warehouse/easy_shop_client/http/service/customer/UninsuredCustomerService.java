package com.kobe.warehouse.easy_shop_client.http.service.customer;

import com.kobe.warehouse.easy_shop_client.http.request.QueryParams;
import com.kobe.warehouse.easy_shop_client.view_model.customer.UninsuredCustomer;

import java.util.List;

public interface UninsuredCustomerService {
  List<UninsuredCustomer> fetch(QueryParams queryParams);

  UninsuredCustomer add(UninsuredCustomer uninsuredCustomer);
  UninsuredCustomer update(UninsuredCustomer uninsuredCustomer);
}
