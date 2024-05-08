package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.view_model.control.button.Add;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.Constant;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.utils.Formater;
import javafx.beans.property.ObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;

public class TotauxView implements Builder<StackPane> {
  private final ObjectProperty<SaleModel> saleModelObjectProperty;
  private final ObjectProperty<Integer> monnaieProperty;
  private final StackPane stackPane;

  public TotauxView(
      ObjectProperty<SaleModel> saleModelObjectProperty, ObjectProperty<Integer> monnaieProperty) {
    this.saleModelObjectProperty = saleModelObjectProperty;
    this.monnaieProperty = monnaieProperty;
    this.stackPane = new StackPane();
  }

  @Override
  public StackPane build() {
    VBox vBox = new VBox();
    vBox.visibleProperty().bind(this.saleModelObjectProperty.isNotNull());
    vBox.setPadding(new Insets(100, 5, 5, 5));
    vBox.setSpacing(5);
    HBox totalVente = new HBox();
    Label label = new Label(Constant.TOTAL_VENTE);
    label.getStyleClass().add("wr-label");

    Label labelTotalAmount = new Label();
    labelTotalAmount
        .textProperty()
        .bind(
            this.saleModelObjectProperty.map(
                sale -> Formater.formatIntegerToXOF(sale.getSalesAmount())));
    // labelTotalAmount.getStyleClass().add("wr-label");
    totalVente.getChildren().setAll(label, labelTotalAmount);
    Separator separator1 = new Separator();

    HBox montantNet = new HBox();
    Label labelMontantNet = new Label(Constant.TOTAL_NET);
    labelMontantNet.getStyleClass().add("wr-label");

    Label montantNetLabel = new Label();
    montantNetLabel
        .textProperty()
        .bind(
            this.saleModelObjectProperty.map(
                sale -> Formater.formatIntegerToXOF(sale.getNetAmount())));
    montantNet.getChildren().setAll(labelMontantNet, montantNetLabel);

    Separator separator2 = new Separator();
    HBox monnaie = new HBox();
    Label labelMonnaie = new Label(Constant.MONNAIE);
    labelMonnaie.getStyleClass().add("wr-label");

    Label monnaieLabel = new Label();
    monnaieLabel.textProperty().bind(this.monnaieProperty.map(Formater::formatIntegerToXOF));
    monnaie.getChildren().setAll(labelMonnaie, monnaieLabel);

    Separator separator3 = new Separator();
    HBox discount = new HBox();
    Label labelDiscount = new Label(Constant.DISCOUNT);
    labelDiscount.getStyleClass().add("wr-label");
    Label discountLabel = new Label();
    discountLabel
        .textProperty()
        .bind(
            this.saleModelObjectProperty.map(
                sale -> Formater.formatIntegerToXOF(sale.getDiscountAmount())));
    discount.getChildren().setAll(labelDiscount, discountLabel);

    Separator separator4 = new Separator();
    HBox tva = new HBox();
    Label labelTva = new Label(Constant.TVA);
    labelTva.getStyleClass().add("wr-label");
    Label tvaLabel = new Label();
    tvaLabel
        .textProperty()
        .bind(
            this.saleModelObjectProperty.map(
                sale -> Formater.formatIntegerToXOF(sale.getTaxAmount())));
    tva.getChildren().setAll(labelTva, tvaLabel);
    Separator separator5 = new Separator();
    HBox btns = new HBox();
    btns.setSpacing(5);
    Button btnTerminer =
        new Add(FontAwesomeSolid.CHECK.getDescription(), Constant.BTN_TERMINER).build();
    btnTerminer.getStyleClass().setAll("btn-add", "btn", "btn-primary");
    Button btnEnAttente =
        new Add(FontAwesomeSolid.REPLY_ALL.getDescription(), Constant.BTN_VENTE_EN_ATTENTE).build();
    btnEnAttente.getStyleClass().setAll("btn-add", "btn", "btn-danger");
    btns.getChildren().setAll(btnTerminer, btnEnAttente);
    vBox.getChildren()
        .addAll(
            totalVente,
            separator1,
            montantNet,
            separator2,
            discount,
            separator3,
            tva,
            separator4,
            monnaie,
            separator5,
            btns,
            new Separator());
    this.stackPane.getChildren().add(vBox);
    return this.stackPane;
  }
}
