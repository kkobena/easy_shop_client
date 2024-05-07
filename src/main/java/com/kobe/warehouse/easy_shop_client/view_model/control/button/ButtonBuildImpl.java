package com.kobe.warehouse.easy_shop_client.view_model.control.button;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.Objects;

public abstract class ButtonBuildImpl implements ButtonBuilder {
  private final Button button;

  protected ButtonBuildImpl( String iconLiteral, String text, int iconSize) {
    this.button = new Button();
    if (Objects.nonNull(text) && !text.isBlank()) {
      this.button.setText(text);
    }
    if (Objects.nonNull(iconLiteral) && !iconLiteral.isBlank()) {
      FontIcon icon = new FontIcon(iconLiteral);
      if (iconSize > 0) {
        icon.setIconSize(iconSize);
      } else {
        icon.setIconSize(24);
      }
      icon.setIconColor(Color.rgb(255,255,255));
      button.setGraphic(icon);
    }
  }

  protected Button buildButton() {
    return this.button;
  }
}
