package com.kobe.warehouse.easy_shop_client.menu;

import com.kobe.warehouse.easy_shop_client.http.response.menu.Menu;

import java.util.List;

public interface MenuService {
  List<Menu> getConnectedUserMenus();
}
