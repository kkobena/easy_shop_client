package com.kobe.warehouse.easy_shop_client.http.service.sale;

import com.kobe.warehouse.easy_shop_client.http.response.sale.Remise;

import java.util.List;

public interface RemiseService {
  List<Remise> fetch();
}
