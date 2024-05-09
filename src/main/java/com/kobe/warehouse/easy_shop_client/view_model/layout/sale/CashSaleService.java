package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.service.sale.SaleService;
import com.kobe.warehouse.easy_shop_client.view_model.sale.CashSaleModel;

public class CashSaleService {
  private final SaleService saleService;
//  private final ObjectProperty<SaleModel> currentSale;

  public CashSaleService(SaleService saleService) {

    this.saleService = saleService;
  //  this.currentSale = currentSale;
  }

  public CashSaleModel createComptant(CashSaleModel cashSaleModel) throws RemoteException, ServerException{
    return this.saleService.createComptant(cashSaleModel);

  }
}
