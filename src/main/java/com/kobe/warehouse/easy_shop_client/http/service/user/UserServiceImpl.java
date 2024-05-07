package com.kobe.warehouse.easy_shop_client.http.service.user;

import com.kobe.warehouse.easy_shop_client.http.HttpService;
import com.kobe.warehouse.easy_shop_client.http.HttpServiceImpl;
import com.kobe.warehouse.easy_shop_client.http.request.EasyShopHttpRequest;
import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.view_model.user.User;
import java.util.List;

public class UserServiceImpl implements UserService {
  private final HttpService<UserInfo> httpService;

  public UserServiceImpl() {
    this.httpService = new HttpServiceImpl<>(UserInfo.class);
  }

  @Override
  public void authenticate(String login, String password) {
    this.httpService.authenticate(login, password);
  }

  @Override
  public List<User> test() {
    return null;
  }

  /*
    @Override
    public void test() {
      httpService.post(
          new EasyShopHttpRequest()
              .setEndPoint("account")
              .setBody(new ManagedUser().setPassword("kobea").setLogin("ko")));
    }
  */
  @Override
  public List<UserInfo> fetchAll() {
    return httpService.fetch(new EasyShopHttpRequest().setEndPoint("users"));
  }
}
