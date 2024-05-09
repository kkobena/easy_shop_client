package com.kobe.warehouse.easy_shop_client.http.service.produit;

import com.kobe.warehouse.easy_shop_client.http.HttpService;
import com.kobe.warehouse.easy_shop_client.http.HttpServiceImpl;
import com.kobe.warehouse.easy_shop_client.http.request.EasyShopHttpRequest;
import com.kobe.warehouse.easy_shop_client.http.request.QueryParams;
import com.kobe.warehouse.easy_shop_client.view_model.produit.Produit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProduitServiceImpl implements ProduitService {
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private final HttpService<Produit> httpService;
  private final String endPoint = "produits";
  private final String endPointLite = endPoint + "/lite";

  public ProduitServiceImpl() {
    this.httpService = new HttpServiceImpl<>(Produit.class);
  }

  @Override
  public List<Produit> fetchAll(String search) {
    try {
      if (Objects.isNull(search) || search.isEmpty()) {
        return new ArrayList<>();
      }
      return this.httpService.fetch(
          new EasyShopHttpRequest()
              .setEndPoint(endPointLite)
              .setQueryParams(new QueryParams().setSearch(search)));
    } catch (Exception e) {
      log.log(Level.FINER, null, e);
      return new ArrayList<>();
    }
  }

 
}
