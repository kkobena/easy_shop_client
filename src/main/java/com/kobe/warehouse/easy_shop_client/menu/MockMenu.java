package com.kobe.warehouse.easy_shop_client.menu;

import com.kobe.warehouse.easy_shop_client.http.response.menu.Menu;
import org.kordamp.ikonli.fontawesome5.FontAwesomeRegular;
import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MockMenu implements MenuService {
  private AtomicInteger atomicInteger = new AtomicInteger(1);

  @Override
  public List<Menu> getConnectedUserMenus() {
    Menu module = new Menu();
    module
        .setId(atomicInteger.getAndIncrement())
        .setIconJavaClient("mdi2t-truck-delivery-outline")
        .setName("Test" + atomicInteger.getAndIncrement())
        .setLibelle("GESTION DES UTILISATEURS")
        .setRoot(true)
        .getMenus()
        .add(
            new Menu()
                .setId(atomicInteger.getAndIncrement())
                .setIconJavaClient("mdi2t-truck")
                .setName("ventes-en-cours")
                .setLibelle("Test  " + atomicInteger.getAndIncrement()));

    List<Menu> menus = new LinkedList<>();
    menus.add(module);
    module = new Menu();
    module
        .setId(atomicInteger.getAndIncrement())
        .setIconJavaClient(MaterialDesignA.ARROW_LEFT_CIRCLE_OUTLINE.getDescription())
        .setName("GESTION DES UTILISATEURS" + atomicInteger.getAndIncrement())
        .setLibelle("Test  " + atomicInteger.getAndIncrement())
        .setRoot(true)
        .getMenus()
        .add(
            new Menu()
                .setId(atomicInteger.getAndIncrement())
                .setIconJavaClient(MaterialDesignA.ARROW_LEFT_BOLD_CIRCLE_OUTLINE.getDescription())
                .setName("Test" + atomicInteger.getAndIncrement())
                .setLibelle("Test  " + atomicInteger.getAndIncrement()));
    menus.add(module);
    return menus;
  }
}
