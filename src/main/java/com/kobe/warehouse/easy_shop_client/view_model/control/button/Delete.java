package com.kobe.warehouse.easy_shop_client.view_model.control.button;

import javafx.scene.control.Button;

public class Delete extends ButtonBuildImpl {
  private Button addBtn;

  public Delete(String iconLiteral, String text, int iconSize) {
    super(iconLiteral, text, iconSize);
    this.addBtn = this.buildButton();

  }

  @Override
  public Button build() {
    this.addBtn.getStyleClass().setAll("btn-delete","btn-sm","btn-danger");
    return this.addBtn;
  }
  public Delete(String iconLiteral, String text) {
    super(iconLiteral, text, 16);
    this.addBtn = this.buildButton();
  }
  public Delete(String iconLiteral, int iconSize) {
    super(iconLiteral, null, iconSize);
    this.addBtn = this.buildButton();
  }

  public Delete(String iconLiteral) {
    super(iconLiteral, null, 16);
    this.addBtn = this.buildButton();
  }
  public Delete() {
    super(null, Constant.BTN_DELETE, 0);
    this.addBtn = this.buildButton();
  }
}
