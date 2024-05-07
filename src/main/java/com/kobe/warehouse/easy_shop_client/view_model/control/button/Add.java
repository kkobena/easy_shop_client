package com.kobe.warehouse.easy_shop_client.view_model.control.button;

import javafx.scene.control.Button;

public class Add extends ButtonBuildImpl {
  private Button addBtn;

  public Add(String iconLiteral, String text, int iconSize) {
    super(iconLiteral, text, iconSize);
    this.addBtn = this.buildButton();

  }
  public Add(String iconLiteral, String text) {
    super(iconLiteral, text, 16);
    this.addBtn = this.buildButton();
  }
  @Override
  public Button build() {
    this.addBtn.getStyleClass().setAll("btn-add","btn","btn-success");
    return this.addBtn;
  }

  public Add(String iconLiteral, int iconSize) {
    super(iconLiteral, null, iconSize);
    this.addBtn = this.buildButton();
  }

  public Add(String iconLiteral) {
    super(iconLiteral, null, 16);
    this.addBtn = this.buildButton();
  }
  public Add() {
    super(null, Constant.ADD_BTN, 0);
    this.addBtn = this.buildButton();
  }

}
