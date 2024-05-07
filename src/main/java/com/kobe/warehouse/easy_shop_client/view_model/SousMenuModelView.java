package com.kobe.warehouse.easy_shop_client.view_model;

import com.kobe.warehouse.easy_shop_client.http.response.menu.Menu;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Builder;
import org.kordamp.ikonli.javafx.FontIcon;

public class SousMenuModelView implements Builder<Label> {
  private Label sousMenu;
  private final VBox parent;
  private final Menu menu;

  public SousMenuModelView(Menu menu, VBox  parent) {
      this.parent = parent;

    /* ImageView icon = new ImageView("@images" + menu.getIconJavaClient());
    icon.setPreserveRatio(true);
    icon.setPickOnBounds(true);
    icon.setFitHeight(24);
    icon.setFitWidth(24);*/

    // this.sousMenu.textProperty().b

    this.menu = menu;
  }

  @Override
  public Label build() {
    this.sousMenu = new Label();
    this.sousMenu.setId(menu.getName());
    this.sousMenu.setText(menu.getLibelle());
   // this.sousMenu.setMinSize(300.0, 17.0);
    this.sousMenu.setPrefWidth(240.0);

  // this.sousMenu.prefWidthProperty().bindBidirectional( parent.prefWidthProperty());
    this.sousMenu.getStyleClass().add("menu_item_label");
    this.sousMenu.setCursor(Cursor.HAND);
    this.sousMenu.setPadding(new Insets(3));
    FontIcon icon = new FontIcon(menu.getIconJavaClient());
    icon.setIconSize(18);
    // icon.setIconColor(Color.rgb(81,131,252));
    icon.setIconColor(Color.rgb(50, 98, 229));
    this.sousMenu.setGraphic(icon);

    return sousMenu;
  }
}
