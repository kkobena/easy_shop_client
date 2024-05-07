package com.kobe.warehouse.easy_shop_client.http.service.sale;

import com.kobe.warehouse.easy_shop_client.http.HttpService;
import com.kobe.warehouse.easy_shop_client.http.HttpServiceImpl;
import com.kobe.warehouse.easy_shop_client.http.request.EasyShopHttpRequest;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Remise;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemiseServiceImpl implements RemiseService {
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private final HttpService<Remise> httpService;

  public RemiseServiceImpl() {
    this.httpService = new HttpServiceImpl<>(Remise.class);
  }

  @Override
  public List<Remise> fetch() {
    try {

      return this.httpService.fetch(new EasyShopHttpRequest().setEndPoint("remises"));
    } catch (Exception e) {
      log.log(Level.INFO, null, e);
      return new ArrayList<>();
    }
  }
}
