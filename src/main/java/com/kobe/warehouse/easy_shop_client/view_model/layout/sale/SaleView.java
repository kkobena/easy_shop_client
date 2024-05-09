package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.config.ApplicationConfigurer;
import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Remise;
import com.kobe.warehouse.easy_shop_client.http.service.sale.SaleService;
import com.kobe.warehouse.easy_shop_client.http.service.sale.SaleServiceImpl;
import com.kobe.warehouse.easy_shop_client.view_model.NatureVente;
import com.kobe.warehouse.easy_shop_client.view_model.TypePrescription;
import com.kobe.warehouse.easy_shop_client.view_model.control.alert.ErrorAlert;
import com.kobe.warehouse.easy_shop_client.view_model.control.combo.experimental.CustomTextField;
import com.kobe.warehouse.easy_shop_client.view_model.customer.UninsuredCustomer;
import com.kobe.warehouse.easy_shop_client.view_model.produit.Produit;
import com.kobe.warehouse.easy_shop_client.view_model.sale.CashSaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleLineModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

import java.util.Objects;

public class SaleView implements Builder<HBox> {
  private HBox main;
  private final SaleService saleService;
  private final ObjectProperty<SaleModel> currentSale;
  private final ObjectProperty<UserInfo> selectedUser;
  private final ObjectProperty<TypePrescription> selectedTypePrescription;
  private final ObjectProperty<NatureVente> selectedNatureVente;
  private final ObjectProperty<Remise> selectedRemise;
  private final ObjectProperty<UninsuredCustomer> uninsuredCustomer = new SimpleObjectProperty<>();
  private final ObjectProperty<ControlFocus> controlFocus = new SimpleObjectProperty<>();
  private final SaleItemTableView saleItemTableView;
  private final TotauxView totauxView;
  private final ObjectProperty<Integer> monnaieProperty = new SimpleObjectProperty<>();
  private final CashSaleService cashSaleService;
  private CustomTextField produitTextField;
  private TextField produitQtyTxtField;
  private Button btnAddProduit;
  private final ObjectProperty<Produit> selectedProduit;

  public SaleView() {
    this.selectedUser = new SimpleObjectProperty<>();
    this.selectedProduit = new SimpleObjectProperty<>();
    this.saleService = new SaleServiceImpl();
    this.currentSale = new SimpleObjectProperty<>();
    this.selectedTypePrescription = new SimpleObjectProperty<>();
    this.selectedNatureVente = new SimpleObjectProperty<>();
    this.selectedRemise = new SimpleObjectProperty<>();
    this.cashSaleService = new CashSaleService(this.saleService);
    this.saleItemTableView = new SaleItemTableView(this.saleService, this.currentSale);
    this.totauxView = new TotauxView(this.currentSale, monnaieProperty);
    ApplicationConfigurer.remoteException.addListener(
        (observable, oldValue, newValue) -> {
          new ErrorAlert();
        });
    ApplicationConfigurer.serverException.addListener(
        (observable, oldValue, newValue) -> {
          new ErrorAlert();
        });
  }

  @Override
  public HBox build() {
    this.main = new HBox();
    CommonRightView right =
        new CommonRightView(
            this.selectedUser,
            this.selectedNatureVente,
            this.selectedTypePrescription,
            this.selectedRemise);

    CommonTopView topView =
        new CommonTopView(
            this.selectedProduit,
            this.saleService,
            this.currentSale,
            this.selectedUser,
            this.controlFocus);
    VBox rightView = right.build();

    UninsuredCustomerView uninsuredCustomerView =
        new UninsuredCustomerView(this.uninsuredCustomer, this.controlFocus);

    HBox.setHgrow(rightView, Priority.SOMETIMES);
    this.main.getChildren().add(rightView);
    VBox top = new VBox();
    top.setPadding(new javafx.geometry.Insets(0, 0, 5, 5));
    HBox hBoxTop = topView.build();
    this.produitTextField = (CustomTextField) hBoxTop.lookup("#produitTxtField");
    this.produitQtyTxtField = (TextField) hBoxTop.lookup("#produitQtyTxtField");
    this.btnAddProduit = (Button) hBoxTop.lookup("#btnAddProduit");
    this.produitQtyTxtField.setOnKeyPressed(this::handleQuantityInput);
    this.produitTextField.setOnKeyPressed(this::handleProduitInput);
    this.btnAddProduit.setOnAction(event -> this.onValidateQuantity());
    HBox center = new HBox();
    center.setSpacing(10);
    center.getChildren().setAll(this.saleItemTableView.build(), this.totauxView.build());

    top.getChildren()
        .setAll(
            uninsuredCustomerView.build(),
            buildSeparator(),
            hBoxTop,
            buildSeparator(), /* put in assured customer*/
            center);
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

  private Separator buildSeparator() {
    Separator separator = new Separator();

    //   separator.setPrefWidth(1000);
    separator.setOrientation(Orientation.HORIZONTAL);
    return separator;
  }

  private void addItems() {
    if (Objects.nonNull(this.currentSale.get())) {

    } else {
      createSale();
    }
  }

  private void handleQuantityInput(KeyEvent e) {
    if (e.getCode() == KeyCode.ENTER) {
      addItems();
      //  this.cashSaleService.createComptant();
      //    onValidateQuantity();
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
    e.consume();
  }

  private void onValidateQuantity() {
    if (!this.produitQtyTxtField.getText().isEmpty()) {
      this.produitQtyTxtField.setText(1 + "");
      this.produitTextField.clear();
      this.produitTextField.requestFocus();
      this.selectedProduit.setValue(null);
    }
  }

  private void handleProduitInput(KeyEvent e) {
    if (e.getCode() == KeyCode.ENTER) {
      if (this.produitTextField.getText().isEmpty()) {
        System.err.println("qsjcsdhshcuss");
      }
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

  private void createSale() {
    try {

      switch (this.selectedNatureVente.get()) {
        case COMPTANT -> {
          this.currentSale.setValue(this.cashSaleService.createComptant(cashSaleModel()));

        }
        case ASSURANCE -> {}
        case CARNET -> {}
      }

      onValidateQuantity();
    } catch (RemoteException | ServerException e) {
      if (e instanceof RemoteException) {
        ApplicationConfigurer.remoteException.setValue((RemoteException) e);
      } else {
        ApplicationConfigurer.serverException.setValue((ServerException) e);
      }
    }
  }

  private SaleLineModel createSaleLineModel() {
    SaleLineModel saleLineModel = new SaleLineModel();
    saleLineModel.setQuantityRequested(Integer.parseInt(produitQtyTxtField.getText()));
    saleLineModel.setQuantitySold(Integer.parseInt(produitQtyTxtField.getText()));
    saleLineModel.setProduitId(selectedProduit.get().getId());
    saleLineModel.setRegularUnitPrice(selectedProduit.get().getRegularUnitPrice());
    if (currentSale.get() != null) {
      saleLineModel.setSaleId(currentSale.get().getId());
    }

    return saleLineModel;
  }

  private CashSaleModel cashSaleModel() {
    CashSaleModel saleModel = new CashSaleModel();
    saleModel.customerProperty().bind(this.uninsuredCustomer);
    saleModel.setSeller(this.selectedUser.get());
    saleModel.setTypePrescription(this.selectedTypePrescription.get());
    saleModel.setNatureVente(this.selectedNatureVente.get());
    //  saleModel.setCassier(ApplicationConfigurer.currentUser.get());// TODO: apres la gestion de
    // l'authentification
    saleModel.setCassier(this.selectedUser.get()); // TODO: apres la gestion de l'authentification
    saleModel.setSalesLines(FXCollections.observableArrayList(createSaleLineModel()));
    return saleModel;
  }
}
