package com.kobe.warehouse.easy_shop_client.http.service.sale;

import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.request.SaleQueryParams;
import com.kobe.warehouse.easy_shop_client.http.response.sale.CashSale;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Sale;
import com.kobe.warehouse.easy_shop_client.view_model.sale.CashSaleModel;

import java.util.List;

public interface SaleService {

  List<Sale> fetch(SaleQueryParams queryParams);

  CashSaleModel create(CashSaleModel cashSale) throws RemoteException, ServerException;
}
