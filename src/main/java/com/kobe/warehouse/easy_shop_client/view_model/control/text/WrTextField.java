package com.kobe.warehouse.easy_shop_client.view_model.control.text;

import javafx.scene.control.TextField;
import javafx.util.Builder;

public class WrTextField implements Builder<TextField> {
  private final TextField textField;

  public WrTextField() {
    this.textField = new TextField();
    this.textField.setMinHeight(30);

  }

  @Override
  public TextField build() {
    return this.textField;
  }
}
