package com.kobe.warehouse.easy_shop_client.view_model.utils;

import com.kobe.warehouse.easy_shop_client.view_model.layout.sale.SaleView;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.util.Builder;

public class MenuRegistry {
  private static final Logger log = Logger.getLogger(MenuRegistry.class.getName());
  private static final Map<String, Class<? extends Builder>> menus = new HashMap<>();

  public static void registerMenu() {
    menus.put("ventes-en-cours", SaleView.class);
  }

  public static Optional<Node> getMenu(String className) {
    Class<? extends Builder> clazz = menus.get(className);
    if (clazz != null) {
      try {
        return Optional.ofNullable((Node) clazz.getDeclaredConstructor().newInstance().build());
      } catch (Exception e) {
        log.log(Level.SEVERE, null, e);
      }
    }
    return Optional.empty();
  }
}
