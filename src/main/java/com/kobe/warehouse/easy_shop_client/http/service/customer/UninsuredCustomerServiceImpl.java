package com.kobe.warehouse.easy_shop_client.http.service.customer;

import com.kobe.warehouse.easy_shop_client.http.HttpService;
import com.kobe.warehouse.easy_shop_client.http.HttpServiceImpl;
import com.kobe.warehouse.easy_shop_client.http.request.EasyShopHttpRequest;
import com.kobe.warehouse.easy_shop_client.http.request.QueryParams;
import com.kobe.warehouse.easy_shop_client.view_model.customer.UninsuredCustomer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UninsuredCustomerServiceImpl implements UninsuredCustomerService {
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private final HttpService<UninsuredCustomer> httpService;
  private final String endPoint = "customers";

  public UninsuredCustomerServiceImpl() {
    this.httpService = new HttpServiceImpl<>(UninsuredCustomer.class);
  }

  @Override
  public List<UninsuredCustomer> fetch(QueryParams queryParams) {

    try {
      if (Objects.isNull(queryParams)
          || Objects.isNull(queryParams.getSearch())
          || queryParams.getSearch().isEmpty()) {
        return new ArrayList<>();
      }
      return this.httpService.fetch(
          new EasyShopHttpRequest().setEndPoint(endPoint).setQueryParams(queryParams.setType("STANDARD")));
    } catch (Exception e) {
      log.log(Level.SEVERE, null, e);
      return new ArrayList<>();
    }
  }

  @Override
  public UninsuredCustomer add(UninsuredCustomer uninsuredCustomer) {
    return null;
  }

  @Override
  public UninsuredCustomer update(UninsuredCustomer uninsuredCustomer) {
    return null;
  }
}
