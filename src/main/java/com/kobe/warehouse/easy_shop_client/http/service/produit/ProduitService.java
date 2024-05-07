package com.kobe.warehouse.easy_shop_client.http.service.produit;

import com.kobe.warehouse.easy_shop_client.view_model.produit.Produit;

import java.util.List;

public interface ProduitService {
  List<Produit> fetchAll(String search);

}
