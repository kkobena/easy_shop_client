package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.config.ApplicationConfigurer;
import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.service.sale.SaleService;
import com.kobe.warehouse.easy_shop_client.view_model.sale.CashSaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleModel;
import javafx.beans.property.ObjectProperty;

public class CashSaleService {
  private final SaleService saleService;
  private final ObjectProperty<SaleModel> currentSale;

  public CashSaleService(SaleService saleService, ObjectProperty<SaleModel> currentSale) {

    this.saleService = saleService;
    this.currentSale = currentSale;
  }

  public void createComptant() {
    try {
      currentSale.map(saleModel -> this.saleService.createComptant((CashSaleModel) saleModel));
    } catch (RemoteException | ServerException e) {
      if (e instanceof RemoteException) {
        ApplicationConfigurer.remoteException.setValue((RemoteException) e);
      } else {
        ApplicationConfigurer.serverException.setValue((ServerException) e);
      }
    }
  }
}
