package com.kobe.warehouse.easy_shop_client.view_model.control.combo;

import com.kobe.warehouse.easy_shop_client.view_model.produit.Produit;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Builder;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.controlsfx.control.SearchableComboBox;

public class ProduitControl implements Builder<ComboBox<Produit>> {
  private final ComboBox produitControl;
  private NumberFormat numberFormat = NumberFormat.getNumberInstance();

  public ProduitControl() {

    this.produitControl = new SearchableComboBox();
    List<Produit> serverDatabase = new ArrayList<>();
    Produit produit = new Produit();
    produit.setLibelle("COTRIMOXAZOLE UBI 480MG CPR 10BL10");
    produit.setRegularUnitPrice(585330);
    produit.setTotalQuantity(10);
    produit.setCodeCip("8597291");
    serverDatabase.add(produit);

    produit = new Produit();
    produit.setLibelle("ADEBA SAV DX PUIF HLE PALM SS PARF 200G");
    produit.setRegularUnitPrice(7870);
    produit.setCodeCip("6050482");
    produit.setTotalQuantity(0);
    serverDatabase.add(produit);
    this.produitControl.getItems().setAll(serverDatabase);
    this.produitControl.setEditable(true);
    this.produitControl.getStyleClass().add("wr-combo");
    this.produitControl.setCellFactory(new ItemCellFactory());
  //  this.produitControl.getEditor().requestFocus();
    this.produitControl
        .getEditor()
        .textProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              if (!newValue.isEmpty()) {
                // Cancel any ongoing search task
                //  cancelSearch();

                // Start a new search task with the updated text
                // search(newValue, comboBox);
              }
            });

    this.produitControl.setConverter(
        new StringConverter<Produit>() {
          @Override
          public String toString(Produit produit) {
            return Objects.nonNull(produit) ? produit.getLibelle() : null;
          }

          @Override
          public Produit fromString(String string) {
            System.err.println(string);
            return null;
          }
        });

    // Customize the popup rendering
    /* autoCompletion.setOnAutoCompleted(
    event -> {
      // Get the ListView used by the AutoCompletionPopup
      ListView<Produit> listView =
          (ListView<Produit>) autoCompletion.getAutoCompletionPopup().getSkin().getNode();

      // Set a custom cell factory to customize the rendering of items
      listView.setCellFactory(
          param ->
              new ListCell<>() {
                @Override
                protected void updateItem(Produit item, boolean empty) {
                  System.err.println("sfsfsf");
                  ;
                  super.updateItem(item, empty);
                  if (empty || item == null) {
                    setText(null);
                  } else {
                    setText(item.getLibelle());

                    // Example: Add a label to each item in the popup
                    // setGraphic(new Label("Custom Label: " + item));
                  }
                }
              });
    });*/
  }

  @Override
  public ComboBox build() {
    return this.produitControl;
  }

  private class ItemCellFactory implements Callback<ListView<Produit>, ListCell<Produit>> {

    @Override
    public ListCell<Produit> call(ListView<Produit> param) {
      return new ProduitControlSkin();
    }
  }

  private class ProduitControlSkin extends ListCell<Produit> {
    @Override
    protected void updateItem(Produit item, boolean empty) {
      super.updateItem(item, empty);
      if (empty) {
        setText(null);
        setGraphic(null);
      } else {

        setGraphic(new ProduitComboItemSkin(item).build());
      }
    }
  }

  private class ProduitComboItemSkin implements Builder<HBox> {
    private HBox item;
    private final Font font = Font.font(12.0);
    private final Color color = Color.rgb(39, 39, 39);
    private final Color stockless = Color.rgb(220, 53, 69);

    public ProduitComboItemSkin(Produit produit) {
      item = new HBox();
      item.setSpacing(5);
      item.setMaxWidth(Double.MAX_VALUE);
      item.setMinHeight(15.0);
      item.setFillHeight(true);
      Label codeCip = new Label(produit.getCodeCip());
      codeCip.setFont(font);
      codeCip.setPrefSize(50, 15);
      codeCip.setTextAlignment(TextAlignment.LEFT);
      codeCip.setAlignment(Pos.CENTER_LEFT);
      Label libelle = new Label(produit.getLibelle());
      libelle.setPrefSize(240, 15);
      libelle.setFont(font);
      libelle.setTextAlignment(TextAlignment.LEFT);
      libelle.setAlignment(Pos.CENTER_LEFT);
      Label price = new Label(numberFormat.format(produit.getRegularUnitPrice()));
      price.setFont(font);
      price.setPrefSize(50, 15);
      price.setTextAlignment(TextAlignment.RIGHT);
      price.setAlignment(Pos.CENTER_RIGHT);

      if (produit.getTotalQuantity() <= 0) {
        codeCip.setTextFill(stockless);
        libelle.setTextFill(stockless);
        price.setTextFill(stockless);
      } else {
        codeCip.setTextFill(color);
        libelle.setTextFill(color);
        price.setTextFill(color);
      }
      item.getChildren().add(codeCip);
      item.getChildren().add(libelle);
      item.getChildren().add(price);
      HBox.setHgrow(codeCip, Priority.NEVER);
      HBox.setHgrow(libelle, Priority.ALWAYS);
      HBox.setHgrow(price, Priority.NEVER);
    }

    @Override
    public HBox build() {
      return item;
    }
  }
}
