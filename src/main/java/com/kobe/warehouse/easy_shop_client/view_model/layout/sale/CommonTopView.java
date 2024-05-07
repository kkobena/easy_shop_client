package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.http.response.referentiel.Rayon;
import com.kobe.warehouse.easy_shop_client.http.service.sale.SaleService;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.ButtonUtils;
import com.kobe.warehouse.easy_shop_client.view_model.control.combo.ProduitControlBaseText;
import com.kobe.warehouse.easy_shop_client.view_model.control.combo.experimental.CustomTextField;
import com.kobe.warehouse.easy_shop_client.view_model.control.text.NumberTextField;
import com.kobe.warehouse.easy_shop_client.view_model.produit.Produit;

import java.util.Objects;
import java.util.stream.Collectors;

import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleModel;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Builder;

public class CommonTopView implements Builder<HBox> {
  private HBox hBox;
  private Button btnVenteAttente = ButtonUtils.BTN_EN_ATTENTE;
  private final Button btnAddProduit = ButtonUtils.ADD_WITH_ICON;

  private TextField produitQtyTxtField;
  private CustomTextField produitTextField;
  private final ObjectProperty<Produit> selectedProduit;
  private final SaleService saleService;
  private final ObjectProperty<SaleModel> currentSale;
  private final ObjectProperty<UserInfo> selectedUser;
  private final ObjectProperty<ControlFocus> controlFocus;

  public CommonTopView(
      SaleService saleService,
      ObjectProperty<SaleModel> currentSale,
      ObjectProperty<UserInfo> selectedUser,
      ObjectProperty<ControlFocus> controlFocus) {
    this.saleService = saleService;
    this.currentSale = currentSale;
    this.controlFocus = controlFocus;
    this.selectedProduit = new SimpleObjectProperty<>();
    this.selectedUser = selectedUser;
    this.selectedUser.addListener(this::onSelectUser);
    this.btnAddProduit.setOnAction(event -> this.onValidateQuantity());
    this.controlFocus.addListener(
        (observable, oldValue, newValue) -> {

          switch (newValue.getInput()) {
            case PRODUIT_INPUT -> this.produitTextField.requestFocus();
            case PRODUIT_QTY -> this.produitQtyTxtField.requestFocus();
          }
        });
  }

  @Override
  public HBox build() {
    this.hBox = new HBox();
    // this.hBox.setPrefWidth(Double.MAX_VALUE);

   // this.hBox.getStyleClass().setAll("main_pane_content_item", "common_top_view");
    ProduitControlBaseText produitText = new ProduitControlBaseText();
    Label qty = new Label("Qté:");
    qty.setPadding(new Insets(8, 0, 0, 0));
    qty.setMinWidth(30);
    qty.setMaxWidth(30);
    qty.setAlignment(Pos.BASELINE_LEFT);
    HBox.setHgrow(qty, Priority.NEVER);

    this.produitQtyTxtField = new NumberTextField().build();
    this.produitQtyTxtField.setMaxWidth(130);
    this.produitQtyTxtField.setMinWidth(130);
    this.produitQtyTxtField.setMinHeight(35);
    this.produitQtyTxtField.getStyleClass().add("wr-input-text");
    this.produitQtyTxtField.setOnKeyPressed(this::handleQuantityInput);

    HBox.setHgrow(produitQtyTxtField, Priority.NEVER);
    qty.setLabelFor(this.produitQtyTxtField);

    Label stockBadge = new Label();
    stockBadge
        .textProperty()
        .bind(this.selectedProduit.map(produit -> String.valueOf(produit.getTotalQuantity())));
    stockBadge.setMinWidth(70);
    HBox.setHgrow(stockBadge, Priority.NEVER);
    stockBadge.getStyleClass().setAll("badge", "lbl", "h6");
    Label rayonBadge = new Label();

    rayonBadge
        .textProperty()
        .bind(
            this.selectedProduit.map(
                produit ->
                    produit.getRayonProduits().stream()
                        .map(Rayon::getLibelleRayon)
                        .collect(Collectors.joining(","))));
    HBox.setHgrow(rayonBadge, Priority.ALWAYS);
    rayonBadge.getStyleClass().setAll("badge", "lbl", "h6");

    Label stock = new Label("Stock:");
    stock.getStyleClass().setAll("wr-label");
    stock.setPadding(new Insets(4, 0, 0, 0));
    stock.setMinWidth(40);
    stock.setMaxWidth(40);
    HBox.setHgrow(stock, Priority.NEVER);
    stock.setLabelFor(stockBadge);

    Label rayon = new Label("Rayon:");
    rayon.getStyleClass().setAll("wr-label");
    rayon.setPadding(new Insets(4, 0, 0, 0));
    rayon.setMinWidth(45);
    rayon.setMaxWidth(45);
    HBox.setHgrow(rayon, Priority.NEVER);
    rayon.setLabelFor(rayonBadge);

    Label produit = new Label("Produits:");
    produit.getStyleClass().setAll("wr-label");
    produit.setPadding(new Insets(8, 0, 0, 0));
    produit.setMinWidth(55.0);
    produit.setMaxWidth(55.0);
    HBox.setHgrow(produit, Priority.NEVER);

    this.produitTextField = produitText.build();
    this.produitTextField.setPrefWidth(300);
    this.produitTextField.setMinHeight(35);
    this.produitTextField.getStyleClass().add("wr-input-text");
    HBox.setHgrow(produitTextField, Priority.ALWAYS);
    produit.setLabelFor(produitTextField);
    Platform.runLater(() -> this.produitTextField.requestFocus());
    this.produitTextField.textProperty().addListener(this::onProduitTxtClear);

    produitText.selectedProdutProperty().addListener(this::onSelectProduitchanged);

    HBox box = new HBox(5);
    box.setPadding(new Insets(5, 5, 5, 10));
    box.getChildren()
        .setAll(
            produit,
            this.produitTextField,
            qty,
            produitQtyTxtField,
            btnAddProduit,
            stock,
            stockBadge,
            rayon,
            rayonBadge,
            btnVenteAttente);
    HBox.setHgrow(box, Priority.ALWAYS);
    this.hBox.getChildren().add(box);
    return hBox;
  }

  private void onSelectProduitchanged(
      ObservableValue<? extends Produit> prop, Produit oldValue, Produit newValue) {
    this.selectedProduit.setValue(newValue);
    this.produitQtyTxtField.requestFocus();
    this.produitQtyTxtField.setText(1 + "");
    this.produitQtyTxtField.selectAll();
  }

  private void onProduitTxtClear(
      ObservableValue<? extends String> prop, String oldValue, String newValue) {
    if (newValue.isEmpty()) {
      this.selectedProduit.setValue(null);
    }
  }

  private void handleQuantityInput(KeyEvent e) {
    if (e.getCode() == KeyCode.ENTER) {
      onValidateQuantity();
      /*  Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Validation Error");
      alert.setHeaderText(null);
      alert.contentTextProperty().bind(this.selectedProduit.map(Produit::getLibelle));
      alert.showAndWait();*/
      //  this.selectedProduit.setValue(null);

    }

    //  System.out.println(type + ": Key Code=" + keyCode.getName() + ", Text=" + e.getText());
    /*  if (e.getEventType() == KeyEvent.KEY_PRESSED && e.getCode() == KeyCode.F1) {


    }*/
    //  e.consume();
  }

  private void onValidateQuantity() {
    if (!this.produitQtyTxtField.getText().isEmpty()) {
      this.produitQtyTxtField.setText(1 + "");
      this.produitTextField.clear();
      this.produitTextField.requestFocus();
    }
  }

  private void onSelectUser(
      ObservableValue<? extends UserInfo> prop, UserInfo oldValue, UserInfo newValue) {
    if (Objects.isNull(newValue)) {
      this.produitTextField.requestFocus();
    }
  }
}
