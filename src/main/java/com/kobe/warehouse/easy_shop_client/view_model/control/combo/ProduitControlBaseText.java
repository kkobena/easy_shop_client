package com.kobe.warehouse.easy_shop_client.view_model.control.combo;

import com.kobe.warehouse.easy_shop_client.http.service.produit.ProduitService;
import com.kobe.warehouse.easy_shop_client.http.service.produit.ProduitServiceImpl;
import com.kobe.warehouse.easy_shop_client.view_model.produit.Produit;
import com.kobe.warehouse.easy_shop_client.view_model.control.combo.experimental.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Builder;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class ProduitControlBaseText implements Builder<CustomTextField> {
  private final CustomTextField customTextField;
  private NumberFormat numberFormat = NumberFormat.getNumberInstance();
  private final ProduitService produitService;
  private final ObjectProperty<Produit> selectedProdut = new SimpleObjectProperty<>();

  public ProduitControlBaseText() {

    this.produitService = new ProduitServiceImpl();

    this.customTextField = TextFields.createClearableTextField();
    this.customTextField.setMinHeight(30.0);
    this.customTextField.setMinWidth(350.0);

    AutoCompletionBinding<Produit> autoCompletionBinding =
        new AutoCompletionTextFieldBinding<>(
            customTextField, s -> matchingItems(s.getUserText()), new ProduitStringConverter());

    AutoCompletePopup<Produit> colorCompletionPopup =
        autoCompletionBinding.getAutoCompletionPopup();
    var skin =
        new AutoCompletePopupSkin<>(
            colorCompletionPopup,
            param ->
                new ListCell<>() {
                  @Override
                  public void updateItem(Produit item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                      setGraphic(null);
                    } else {
                      setGraphic(new ProduitComboItemSkin(item).build());
                    }
                  }
                });
    colorCompletionPopup.setSkin(skin);

    autoCompletionBinding.setOnAutoCompleted(
        event -> this.selectedProdut.setValue(event.getCompletion()));
  }

  @Override
  public CustomTextField build() {
    return this.customTextField;
  }

  public class ItemCellFactory implements Callback<ListView<Produit>, ListCell<Produit>> {

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
    private final HBox item;

    public ProduitComboItemSkin(Produit produit) {
      item = new HBox();
      item.setSpacing(5);
      item.setMaxWidth(Double.MAX_VALUE);
      item.setMinHeight(15.0);
      item.setFillHeight(true);

      Label codeCip = new Label(produit.getCodeCip());
      Font font = Font.font(12.0);
      codeCip.setFont(font);
      codeCip.setPrefSize(60, 15);
      codeCip.setTextAlignment(TextAlignment.LEFT);
      codeCip.setAlignment(Pos.CENTER_LEFT);

      Label libelle = new Label(produit.getLibelle());
      libelle.setPrefSize(320, 15);
      libelle.setFont(font);
      libelle.setTextAlignment(TextAlignment.LEFT);
      libelle.setAlignment(Pos.CENTER_LEFT);

      Label price = new Label(numberFormat.format(produit.getRegularUnitPrice()));
      price.setFont(font);
      price.setPrefSize(50, 15);
      price.setTextAlignment(TextAlignment.RIGHT);
      price.setAlignment(Pos.CENTER_RIGHT);

      if (produit.getTotalQuantity() <= 0) {
        Color stockless = Color.rgb(220, 53, 69);
        codeCip.setTextFill(stockless);
        libelle.setTextFill(stockless);
        price.setTextFill(stockless);
      } else {
        Color color = Color.rgb(39, 39, 39);
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

  public class ProduitStringConverter extends StringConverter<Produit> {
    @Override
    public String toString(Produit p) {

      return p == null ? null : p.getCodeCip() + " " + p.getLibelle();
    }

    @Override
    public Produit fromString(String string) {

      return null;
    }
  }

  private List<Produit> matchingItems(String prefix) {
    if (!prefix.isEmpty() && prefix.length() > 2) {
      return produitService.fetchAll(prefix);
    } else {
      return new ArrayList<>();
    }
  }

  public final Produit getSelectedProdut() {
    return selectedProdut.get();
  }

  public final ObjectProperty<Produit> selectedProdutProperty() {
    return selectedProdut;
  }
}
