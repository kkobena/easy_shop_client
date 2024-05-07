package com.kobe.warehouse.easy_shop_client.menu;

import com.kobe.warehouse.easy_shop_client.config.ApplicationConfigurer;
import com.kobe.warehouse.easy_shop_client.http.HttpService;
import com.kobe.warehouse.easy_shop_client.http.HttpServiceImpl;
import com.kobe.warehouse.easy_shop_client.http.request.EasyShopHttpRequest;
import com.kobe.warehouse.easy_shop_client.http.request.QueryParams;
import com.kobe.warehouse.easy_shop_client.http.response.menu.Menu;
import java.util.List;

public class MenuServiceImpl implements MenuService {
  private HttpService<Menu> httpService;

  public MenuServiceImpl() {
    httpService = new HttpServiceImpl<>(Menu.class);
  }

  @Override
  public List<Menu> getConnectedUserMenus() {
    return httpService.fetch(
        new EasyShopHttpRequest()
            .setEndPoint("menus")
            .setQueryParams(
                new QueryParams().setUserId(ApplicationConfigurer.currentUser.get().getId())));
  }
}
