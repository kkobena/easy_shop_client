package com.kobe.warehouse.easy_shop_client.http.service.sale;

import com.kobe.warehouse.easy_shop_client.http.HttpService;
import com.kobe.warehouse.easy_shop_client.http.HttpServiceImpl;
import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.request.EasyShopHttpRequest;
import com.kobe.warehouse.easy_shop_client.http.request.KeyValue;
import com.kobe.warehouse.easy_shop_client.http.request.SaleQueryParams;
import com.kobe.warehouse.easy_shop_client.http.response.Pageable;
import com.kobe.warehouse.easy_shop_client.http.response.sale.CashSale;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Sale;
import com.kobe.warehouse.easy_shop_client.view_model.sale.CashSaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleLineModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.utils.SaleConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleServiceImpl implements SaleService {
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private final HttpService<Sale> httpService;
  private final String endPoint = "sales";
  private final String postCashSale = endPoint + "/comptant";
  private final String updateItemQuantityRequestedEndPoint =
      endPoint + "/update-item/quantity-requested";
  private final String updateItemQuantitySoldEndPoint = endPoint + "/update-item/quantity-sold";

  private final String updateItemQuantityPriceEndPoint = endPoint + "/update-item/price";

  private final String addItemComptantEndPoint = endPoint + "/add-item/comptant";
  private final String deleteItemComptant = endPoint + "/delete-item/%d";
  private final String putOnHoldComptant = endPoint + "/comptant/put-on-hold";
  private final String addCustomerComptant = endPoint + "/comptant/add-customer";
  private final String removeCustomerComptant = endPoint + "/comptant/remove-customer/%d";
  private final String deleteItem = endPoint + "/assurance/delete-item/%d";

  public SaleServiceImpl() {
    this.httpService = new HttpServiceImpl<>(Sale.class);
  }

  @Override
  public List<Sale> fetch(SaleQueryParams queryParams) {
    try {

      return this.httpService.fetch(
          new EasyShopHttpRequest().setEndPoint(endPoint).setQueryParams(queryParams));
    } catch (Exception e) {
      log.log(Level.SEVERE, null, e);
      return new ArrayList<>();
    }
  }

  @Override
  public Pageable<Sale> fetchPageable(SaleQueryParams queryParams) {
    return this.httpService.fetchWithPagination(
        new EasyShopHttpRequest().setEndPoint(endPoint).setQueryParams(queryParams));
  }

  @Override
  public CashSaleModel createComptant(CashSaleModel cashSale)
      throws RemoteException, ServerException {
    return (CashSaleModel)
        SaleConverter.convertSaleToModel.apply(
            this.httpService.post(
                new EasyShopHttpRequest()
                    .setEndPoint(postCashSale)
                    .setBody(SaleConverter.convertModelToSale.apply(cashSale)),
                CashSale.class));
  }

  @Override
  public SaleModel findOne(Long saleId) throws RemoteException, ServerException {
    return Optional.ofNullable(
            this.httpService.getOne(new EasyShopHttpRequest().setEndPoint(endPoint + "/" + saleId)))
        .map(SaleConverter.convertSaleToModel)
        .orElse(null);
  }

  @Override
  public CashSaleModel saveComptant(CashSaleModel cashSale)
      throws RemoteException, ServerException {
    return null;
  }

  @Override
  public SaleLineModel addItemComptant(SaleLineModel saleLineModel)
      throws RemoteException, ServerException {
    return this.httpService.post(
        new EasyShopHttpRequest().setEndPoint(addItemComptantEndPoint).setBody(saleLineModel),
        SaleLineModel.class);
  }

  @Override
  public SaleLineModel updateItemPrice(SaleLineModel saleLineModel)
      throws RemoteException, ServerException {
    return this.httpService.put(
        new EasyShopHttpRequest()
            .setEndPoint(updateItemQuantityPriceEndPoint)
            .setBody(saleLineModel),
        SaleLineModel.class);
  }

  @Override
  public SaleLineModel updateItemQtyRequested(SaleLineModel saleLineModel)
      throws RemoteException, ServerException {
    return this.httpService.put(
        new EasyShopHttpRequest()
            .setEndPoint(updateItemQuantityRequestedEndPoint)
            .setBody(saleLineModel),
        SaleLineModel.class);
  }

  @Override
  public SaleLineModel updateItemQtySold(SaleLineModel saleLineModel)
      throws RemoteException, ServerException {
    return this.httpService.put(
        new EasyShopHttpRequest()
            .setEndPoint(updateItemQuantitySoldEndPoint)
            .setBody(saleLineModel),
        SaleLineModel.class);
  }

  @Override
  public void deleteItemComptant(Long saleLineId) throws RemoteException, ServerException {
    this.httpService.deleteRequest(
        new EasyShopHttpRequest().setEndPoint(String.format(deleteItemComptant, saleLineId)));
  }

  @Override
  public void deleteItem(Long saleLineId) throws RemoteException, ServerException {
    this.httpService.deleteRequest(
        new EasyShopHttpRequest().setEndPoint(String.format(deleteItem, saleLineId)));
  }

  @Override
  public void addCustommerToCashSale(KeyValue keyValue) throws RemoteException, ServerException {
    this.httpService.put(
        new EasyShopHttpRequest().setEndPoint(addCustomerComptant).setBody(keyValue), Void.class);
  }

  @Override
  public void deleteCustommerToCashSale(Long customerId) throws RemoteException, ServerException {
    this.httpService.deleteRequest(
        new EasyShopHttpRequest().setEndPoint(String.format(removeCustomerComptant, customerId)));
  }
}
