package com.kobe.warehouse.easy_shop_client.http.service.user;

import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.view_model.user.User;

import java.util.List;

public interface UserService {

  void authenticate(String login,String password);

  List<User> test();

  List<UserInfo> fetchAll();
}
