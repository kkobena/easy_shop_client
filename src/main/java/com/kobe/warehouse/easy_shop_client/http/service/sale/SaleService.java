package com.kobe.warehouse.easy_shop_client.http.service.sale;

import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.request.KeyValue;
import com.kobe.warehouse.easy_shop_client.http.request.SaleQueryParams;
import com.kobe.warehouse.easy_shop_client.http.response.Pageable;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Sale;
import com.kobe.warehouse.easy_shop_client.view_model.sale.CashSaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleLineModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleModel;

import java.util.List;

public interface SaleService {

  List<Sale> fetch(SaleQueryParams queryParams);

  Pageable<Sale> fetchPageable(SaleQueryParams queryParams);

  CashSaleModel createComptant(CashSaleModel cashSale) throws RemoteException, ServerException;

  SaleModel findOne(Long saleId) throws RemoteException, ServerException;

  CashSaleModel saveComptant(CashSaleModel cashSale) throws RemoteException, ServerException;

  SaleLineModel addItemComptant(SaleLineModel saleLineModel)
      throws RemoteException, ServerException;

  SaleLineModel updateItemPrice(SaleLineModel saleLineModel)
      throws RemoteException, ServerException;

  SaleLineModel updateItemQtyRequested(SaleLineModel saleLineModel)
      throws RemoteException, ServerException;

  SaleLineModel updateItemQtySold(SaleLineModel saleLineModel)
      throws RemoteException, ServerException;

  void deleteItemComptant(Long saleLineId) throws RemoteException, ServerException;

  void deleteItem(Long saleLineId) throws RemoteException, ServerException;

  void addCustommerToCashSale(KeyValue keyValue) throws RemoteException, ServerException;

  void deleteCustommerToCashSale(Long customerId) throws RemoteException, ServerException;
}
