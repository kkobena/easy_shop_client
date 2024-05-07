package com.kobe.warehouse.easy_shop_client.view_model;

import com.kobe.warehouse.easy_shop_client.http.response.menu.Menu;
import com.kobe.warehouse.easy_shop_client.view_model.utils.MenuRegistry;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Builder;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.Objects;

public class MenuModelView implements Builder<TitledPane> {
  private TitledPane titledPane;
  private final Menu menu;
  private final ObjectProperty<Node> selectedMenuProperty;

  public MenuModelView(Menu menu, ObjectProperty<Node> selectedMenuProperty) {
    this.menu = menu;
    this.selectedMenuProperty = selectedMenuProperty;
  }

  @Override
  public TitledPane build() {
    this.titledPane = new TitledPane();
    this.titledPane.setAnimated(true);
    // this.titledPane.setFont(Font.font(14.0));
    this.titledPane.getStyleClass().add("menu_item_title_panel");

    this.titledPane.setText(menu.getLibelle());
    // this.titledPane.setPadding(new Insets(5));
    this.titledPane.setId(menu.getName());
    if (Objects.nonNull(menu.getIconJavaClient())) {
      //
      //    ImageView imageView = new ImageView(new
      // Image(getClass().getResource("unlock24.png").toExternalForm()));

      // ImageView icon=new
      // ImageView(MenuModelView.class.getResource("images/basket.png").getFile());
      // ImageView icon=new ImageView("@images/basket.png");
      /*  ImageView icon = new ImageView("@images" + menu.getIconJavaClient());
      icon.setPreserveRatio(true);
      icon.setPickOnBounds(true);
      icon.setFitHeight(26.0);
      icon.setFitWidth(26.0);*/

      FontIcon icon = new FontIcon(menu.getIconJavaClient());
      icon.setIconSize(18);
      icon.setIconColor(Color.rgb(50, 98, 229));
      // font color 248 249 254
      this.titledPane.setGraphic(icon);
      /*
         // title region
          Node titleRegion=title.lookup(".title");
          // padding
          Insets padding=((StackPane)titleRegion).getPadding();
          // image width
          double graphicWidth=imageView.getLayoutBounds().getWidth();
          // arrow
          double arrowWidth=titleRegion.lookup(".arrow-button").getLayoutBounds().getWidth();
          // text
          double labelWidth=titleRegion.lookup(".text").getLayoutBounds().getWidth();

          double nodesWidth = graphicWidth+padding.getLeft()+padding.getRight()+arrowWidth+labelWidth;

          title.graphicTextGapProperty().bind(title.widthProperty().subtract(nodesWidth));
      });
         */

      // this.titledPane.setGraphicTextGap(100);

      this.titledPane.setContentDisplay(ContentDisplay.LEFT);
    }
    VBox vBox = new VBox();
    menu.getMenus()
        .forEach(
            e -> {
              Label sousMenu = new SousMenuModelView(e,vBox).build();
              sousMenu.setOnMouseClicked(
                  event ->
                      this.selectedMenuProperty.setValue(
                          MenuRegistry.getMenu(e.getName()).orElse(new Label(e.getLibelle()))));
              vBox.getChildren().setAll(sousMenu);
            });
    AnchorPane content = new AnchorPane();
    content.setMinHeight(0.0);
    content.setMinWidth(0.0);
   // content.setPrefWidth(80.0);
  //  content.setPrefSize(120.0, 450.0);
    content.getStyleClass().add("menu_item_anchor_panel");
    content.getChildren().add(vBox);
    this.titledPane.setContent(content);
    return this.titledPane;
  }
}
