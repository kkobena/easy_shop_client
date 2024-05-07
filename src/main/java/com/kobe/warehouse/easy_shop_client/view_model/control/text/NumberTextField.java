package com.kobe.warehouse.easy_shop_client.view_model.control.text;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.Builder;

import java.util.function.UnaryOperator;

public class NumberTextField implements Builder<TextField> {
  private final TextField textField;

  public NumberTextField() {
    this.textField = new TextField();
    this.textField.setMinHeight(30);

    UnaryOperator<TextFormatter.Change> filter = change -> {
      String newText = change.getControlNewText();
      if (newText.matches("\\d*")) { // Allow only digits
        return change;
      }
      return null; // Reject the change
    };
    TextFormatter<String> textFormatter = new TextFormatter<>(filter);
    textField.setTextFormatter(textFormatter);

  }

  @Override
  public TextField build() {
    return this.textField;
  }
}
