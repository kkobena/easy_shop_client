package com.kobe.warehouse.easy_shop_client.view_model;

import com.kobe.warehouse.easy_shop_client.http.response.menu.Menu;
import com.kobe.warehouse.easy_shop_client.menu.MenuService;
import com.kobe.warehouse.easy_shop_client.menu.MockMenu;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.util.Builder;

public class MenuAccordionModelView implements Builder<Accordion> {
  private Accordion menuContainer;
  private final MenuService menuService;
  private final ObjectProperty<Node> selectedMenuProperty;

  // menu registry

  public MenuAccordionModelView(ObjectProperty<Node> selectedMenuProperty) {
    this.menuService = new MockMenu();
    this.selectedMenuProperty = selectedMenuProperty;
  }

  @Override
  public Accordion build() {
    this.menuContainer = new Accordion();
 // this.menuContainer.prefHeight(700.0);
   // this.menuContainer.prefWidth(140);
    List<Menu> menus = this.menuService.getConnectedUserMenus();
    if (menus != null && !menus.isEmpty()) {
      menus.forEach(
          menu ->
              this.menuContainer
                  .getPanes()
                  .add(new MenuModelView(menu, selectedMenuProperty).build()));
    }
    return this.menuContainer;
  }
}
