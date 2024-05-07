package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.http.request.QueryParams;
import com.kobe.warehouse.easy_shop_client.http.service.customer.UninsuredCustomerService;
import com.kobe.warehouse.easy_shop_client.http.service.customer.UninsuredCustomerServiceImpl;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.Add;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.ButtonUtils;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.Constant;
import com.kobe.warehouse.easy_shop_client.view_model.customer.UninsuredCustomer;
import java.util.Objects;

import com.kobe.warehouse.easy_shop_client.view_model.customer.UninsuredCustomerForm;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Builder;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;

public class UninsuredCustomerView implements Builder<HBox> {
  private HBox hBox;
  private HBox customerControl;
  private final ObjectProperty<UninsuredCustomer> selectedUninsuredCustomer;
  private final ObjectProperty<ControlFocus> controlFocus;
  private final UninsuredCustomerService uninsuredCustomerService;

  public UninsuredCustomerView(
      ObjectProperty<UninsuredCustomer> selectedUninsuredCustomer,
      ObjectProperty<ControlFocus> controlFocus) {
    this.controlFocus = controlFocus;
    this.selectedUninsuredCustomer = selectedUninsuredCustomer;
    this.uninsuredCustomerService = new UninsuredCustomerServiceImpl();
    this.hBox = new HBox();

  }

  @Override
  public HBox build() {
    Button addBtn =
        new Add(FontAwesomeSolid.USER.getDescription(), Constant.BTN_ADD_CUSTMER).build();
    addBtn.getStyleClass().setAll("btn-add", "btn", "btn-info");
    addBtn.setOnAction(
        event -> {
          if (Objects.isNull(this.selectedUninsuredCustomer.get())) {
            onAddCustomer(addBtn);
          } else {
            this.selectedUninsuredCustomer.setValue(null);
            onAddCustomer(addBtn);
          }
        });
    this.customerControl = this.buildInfoCustomer();
    this.customerControl.visibleProperty().bind(this.selectedUninsuredCustomer.isNotNull());
      this.hBox.setSpacing(3);
      this.hBox.setPadding(new Insets(10.0, 10.0, 5.0, 70.0));
    //  this.hBox.getStyleClass().setAll("main_pane_content_item", "common_top_view");
    this.hBox.getChildren().setAll(addBtn, this.customerControl);

    return this.hBox;
  }

  private void onAddCustomer(Button addBtn) {
    UninsuredCustomerDataTable uninsuredCustomerDataTable = new UninsuredCustomerDataTable();
    TableView<UninsuredCustomer> uninsuredCustomerTableView = uninsuredCustomerDataTable.build();
    /*
       ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
    Dialog<String> dialog = new Dialog<>();
    dialog.getDialogPane().getButtonTypes().add(loginButtonType);
    boolean disabled = false; // computed based on content of text fields, for example
    dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
    dialog.showAndWait()
         .filter(response -> response == ButtonType.OK)
         .ifPresent(response -> formatSystem());

         final Button btOk = (Button) dlg.getDialogPane().lookupButton(ButtonType.OK);
    btOk.addEventFilter(ActionEvent.ACTION, event -> {
        if (!validateAndStore()) {
            event.consume();
        }
    });
        */
    Dialog<?> dialog = new Dialog<>();
    Window window = dialog.getDialogPane().getScene().getWindow();
    window.setOnCloseRequest(event -> window.hide());
    dialog.initModality(Modality.APPLICATION_MODAL);
    dialog.initStyle(StageStyle.UTILITY);
    dialog.setResizable(false);

    //  dialog.
    dialog.setTitle("Ajouter un client à la vente");
    DialogPane dialogPane = new DialogPane();
    /// dialogPane.getStyleClass().add(BootstrapFX.bootstrapFXStylesheet());

    dialogPane.setPrefWidth(800);
    dialogPane.setExpanded(false);
    HBox toolBar = new HBox();
    toolBar.setSpacing(6);
    VBox vBox = new VBox();
    vBox.setSpacing(6);
    TextField searchText = new TextField();
    searchText.prefWidth(200.0);
    searchText.setPrefHeight(35.0);
    searchText
        .textProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              if (!newValue.isEmpty() && newValue.length() > 2) {
                uninsuredCustomerTableView.setItems(
                    FXCollections.observableList(
                        this.uninsuredCustomerService.fetch(
                            new QueryParams().setSearch(newValue).setSize(30))));
              } else {
                uninsuredCustomerTableView.setItems(FXCollections.observableArrayList());
              }
            });

    HBox.setHgrow(searchText, Priority.ALWAYS);
    Button add = new Add(FontAwesomeSolid.USER.getDescription(), Constant.BTN_ADD_CUSTMER).build();
    add.setStyle(ButtonUtils.IN_LINE_STYLE_INFO);
    add.setOnMouseEntered(e -> add.setStyle(ButtonUtils.IN_LINE_STYLE_INFO_HOVER));

    // Normal state style again when mouse exits
    add.setOnMouseExited(e -> add.setStyle(ButtonUtils.IN_LINE_STYLE_INFO));

    add.setOnAction(
        event -> {
          UninsuredCustomerForm uninsuredCustomerForm = new UninsuredCustomerForm(null);
          Button cancel =
              (Button) uninsuredCustomerForm.getDialogPane().lookup("#cutstmerCancelBtn");
          Window formDialog = uninsuredCustomerForm.getDialogPane().getScene().getWindow();
          formDialog.setOnCloseRequest(e -> formDialog.hide());
          cancel.setOnAction(e -> formDialog.hide());

          uninsuredCustomerForm
              .showAndWait()
              .ifPresent(
                  result -> this.selectedUninsuredCustomer.setValue(result));
        });

    // HBox.setHgrow(add, Priority.NEVER);
    toolBar.getChildren().setAll(searchText, add);
    uninsuredCustomerTableView.setRowFactory(
        tv -> {
          TableRow<UninsuredCustomer> row = new TableRow<>();
          row.setOnMouseClicked(
              event -> {
                if (!row.isEmpty()
                    && event.getButton() == MouseButton.PRIMARY
                    && event.getClickCount() == 2) {
                  UninsuredCustomer selectedItem = row.getItem();
                  this.selectedUninsuredCustomer.setValue(selectedItem);
                  // Perform your action here
                }
              });
          return row;
        });
    uninsuredCustomerTableView.addEventFilter(
        KeyEvent.KEY_PRESSED,
        event -> {
          if (event.getCode() == KeyCode.ENTER && event.getEventType() == KeyEvent.KEY_PRESSED) {
            this.selectedUninsuredCustomer.setValue(
                uninsuredCustomerTableView.getSelectionModel().getSelectedItem());
          }
        });

    /* this.selectedUninsuredCustomer.bind(
    uninsuredCustomerTableView.getSelectionModel().selectedItemProperty());*/
    vBox.getChildren().setAll(toolBar, uninsuredCustomerTableView);
    this.selectedUninsuredCustomer.addListener(
        (observable, oldValue, newValue) -> {
          if (Objects.nonNull(newValue)) {
            addBtn.getStyleClass().setAll("btn-add", "btn", "btn-danger");
            addBtn.setText(Constant.BTN_CHANGE_CUSTMER);
            window.hide();
          } else {
            addBtn.getStyleClass().setAll("btn-add", "btn", "btn-info");
            addBtn.setText(Constant.BTN_CHANGE_CUSTMER);
          }
          this.controlFocus.setValue(new ControlFocus(ControlFocus.Input.PRODUIT_INPUT));
        });
    dialogPane.setContent(vBox);
    dialog.setDialogPane(dialogPane);
    dialog.showAndWait();
  }

  private HBox buildInfoCustomer() {

    HBox region = new HBox();
    region.setSpacing(10);
    region.setPadding(new Insets(5, 10, 0, 70));
    Label nomValue = new Label();
    nomValue.maxWidth(300.0);
    HBox.setHgrow(nomValue, Priority.NEVER);
    Label nom = new Label();
    nom.getStyleClass().setAll("wr-label");
    nom.maxWidth(100.0);
    HBox.setHgrow(nom, Priority.NEVER);
    nom.setText("Nom/Prénom(s):");
    nom.setLabelFor(nomValue);
    Label phoneValue = new Label();
    phoneValue.maxWidth(200.0);
    Label phone = new Label();
    phone.getStyleClass().setAll("wr-label");
    phone.setText("Téléphone:");
    phone.maxWidth(100.0);
    HBox.setHgrow(phone, Priority.NEVER);
    phone.setLabelFor(phoneValue);
    HBox.setHgrow(phoneValue, Priority.NEVER);
    phoneValue.getStyleClass().setAll("badge", "lbl", "h6");
    nomValue.getStyleClass().setAll("badge", "lbl", "h6");
    nomValue
        .textProperty()
        .bind(this.selectedUninsuredCustomer.map(UninsuredCustomer::getFullName));
    phoneValue.textProperty().bind(this.selectedUninsuredCustomer.map(UninsuredCustomer::getPhone));
    region.getChildren().setAll(nom, nomValue, phone, phoneValue);
    return region;
  }
}
