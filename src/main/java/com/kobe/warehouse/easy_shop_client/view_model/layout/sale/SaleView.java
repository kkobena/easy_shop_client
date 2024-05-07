package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Remise;
import com.kobe.warehouse.easy_shop_client.http.service.sale.SaleService;
import com.kobe.warehouse.easy_shop_client.http.service.sale.SaleServiceImpl;
import com.kobe.warehouse.easy_shop_client.view_model.NatureVente;
import com.kobe.warehouse.easy_shop_client.view_model.TypePrescription;
import com.kobe.warehouse.easy_shop_client.view_model.customer.UninsuredCustomer;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class SaleView implements Builder<HBox> {
  private HBox main;
  private final SaleService saleService;
  private final ObjectProperty<SaleModel> currentSale;
  private final ObjectProperty<UserInfo> selectedUser;
  private final ObjectProperty<TypePrescription> selectedTypePrescription;
  private final ObjectProperty<NatureVente> selectedNatureVente;
  private final ObjectProperty<Remise> selectedRemise;
  private final ObjectProperty<UninsuredCustomer> uninsuredCustomer = new SimpleObjectProperty<>();
  private final ObjectProperty<ControlFocus> controlFocus =
      new SimpleObjectProperty<>();

  public SaleView() {
    this.selectedUser = new SimpleObjectProperty<>();
    this.saleService = new SaleServiceImpl();
    this.currentSale = new SimpleObjectProperty<>();
    this.selectedTypePrescription = new SimpleObjectProperty<>();
    this.selectedNatureVente = new SimpleObjectProperty<>();
    this.selectedRemise = new SimpleObjectProperty<>();

    // Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    /*  selectedProduit.addListener(
    (observable, oldValue, newValue) -> {
      System.err.println("hello " + newValue);
    });*/
  }

  @Override
  public HBox build() {
    this.main = new HBox();
    CommonRightView right =
        new CommonRightView(this.selectedUser, this.selectedNatureVente, this.selectedRemise);
    CommonTopView topView =
        new CommonTopView(this.saleService, this.currentSale, this.selectedUser,this.controlFocus);
    VBox rightView = right.build();
    UninsuredCustomerView uninsuredCustomerView = new UninsuredCustomerView(this.uninsuredCustomer,this.controlFocus);

    HBox.setHgrow(rightView, Priority.SOMETIMES);
    this.main.getChildren().add(rightView);
    VBox top = new VBox();
    HBox hBoxTop = topView.build();

    top.getChildren().setAll(uninsuredCustomerView.build(), hBoxTop);
    // top .prefWidthProperty().bind(this.main.widthProperty().subtract(200));
    //  top.prefWidth(Double.MAX_VALUE);
    HBox.setHgrow(top, Priority.ALWAYS);
    this.main.getChildren().add(top);
    return this.main;
  }

  private void resetAll() {
    this.selectedTypePrescription.setValue(TypePrescription.PRESCRIPTION);
    this.selectedNatureVente.setValue(NatureVente.COMPTANT);
    // this.selectedUser.setValue(ApplicationConfigurer.currentUser);
  }
}
