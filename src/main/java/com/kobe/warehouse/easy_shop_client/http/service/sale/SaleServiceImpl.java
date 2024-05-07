package com.kobe.warehouse.easy_shop_client.http.service.sale;

import com.kobe.warehouse.easy_shop_client.http.HttpService;
import com.kobe.warehouse.easy_shop_client.http.HttpServiceImpl;
import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.request.EasyShopHttpRequest;
import com.kobe.warehouse.easy_shop_client.http.request.SaleQueryParams;
import com.kobe.warehouse.easy_shop_client.http.response.sale.CashSale;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Sale;
import com.kobe.warehouse.easy_shop_client.view_model.sale.CashSaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.utils.SaleConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleServiceImpl implements SaleService {
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private final HttpService<Sale> httpService;
  private final String endPoint = "sales";
  private final String postCashSale = endPoint + "/comptant";

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
  public CashSaleModel create(CashSaleModel cashSale) throws RemoteException, ServerException {
    return (CashSaleModel)
        SaleConverter.convertSaleToModel.apply(
            this.httpService.post(
                new EasyShopHttpRequest()
                    .setEndPoint(postCashSale)
                    .setBody(SaleConverter.convertModelToSale.apply(cashSale)),
                CashSale.class));
  }


}
