package com.kobe.warehouse.easy_shop_client.view_model.control.button;

import javafx.scene.control.Button;

public class SeeDetails extends ButtonBuildImpl {
  private Button addBtn;

  public SeeDetails(String iconLiteral, String text, int iconSize) {
    super(iconLiteral, text, iconSize);
    this.addBtn = this.buildButton();

  }
  public SeeDetails(String iconLiteral, String text) {
    super(iconLiteral, text, 16);
    this.addBtn = this.buildButton();
  }
  @Override
  public Button build() {
    this.addBtn.getStyleClass().setAll("btn-detail","btn-sm","btn-info");
    return this.addBtn;
  }

  public SeeDetails(String iconLiteral, int iconSize) {
    super(iconLiteral, null, iconSize);
    this.addBtn = this.buildButton();
  }

  public SeeDetails(String iconLiteral) {
    super(iconLiteral, null, 16);
    this.addBtn = this.buildButton();
  }
  public SeeDetails() {
    super(null, Constant.BTN_VIEW, 0);
    this.addBtn = this.buildButton();
  }
}
