package com.kobe.warehouse.easy_shop_client.view_model.control.button;

import javafx.scene.control.Button;

public class SeeSaleOnHold extends ButtonBuildImpl {
  private Button btn;

  public SeeSaleOnHold(String iconLiteral, String text, int iconSize) {
    super(iconLiteral, text, iconSize);
    this.btn = this.buildButton();

  }
  public SeeSaleOnHold(String iconLiteral, String text) {
    super(iconLiteral, text, 16);
    this.btn = this.buildButton();
  }
  @Override
  public Button build() {
    this.btn.getStyleClass().setAll("btn-search","btn-sm","btn-primary");
    return this.btn;
  }

  public SeeSaleOnHold(String iconLiteral, int iconSize) {
    super(iconLiteral,  Constant.BTN_EN_ATTENTE, iconSize);
    this.btn = this.buildButton();
  }

  public SeeSaleOnHold(String iconLiteral) {
    super(iconLiteral, Constant.BTN_EN_ATTENTE, 16);
    this.btn = this.buildButton();
  }
  public SeeSaleOnHold() {
    super(null, Constant.BTN_EN_ATTENTE, 0);
    this.btn = this.buildButton();
  }
}
