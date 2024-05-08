package com.kobe.warehouse.easy_shop_client.http;

import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.request.EasyShopHttpRequest;
import com.kobe.warehouse.easy_shop_client.http.response.Pageable;
import java.util.List;

public interface HttpService<T> {
  T getOne(EasyShopHttpRequest param);

  <R> R post(EasyShopHttpRequest param, Class<R> retour) throws RemoteException, ServerException;

  <R> R put(EasyShopHttpRequest param, Class<R> retour) throws RemoteException, ServerException;

  List<T> fetch(EasyShopHttpRequest param);

  default Pageable<T> fetchWithPagination(EasyShopHttpRequest param) {
    return new Pageable<>(0, List.of());
  }

  void deleteRequest(EasyShopHttpRequest param);

  default void authenticate(String login, String password) {}
}
