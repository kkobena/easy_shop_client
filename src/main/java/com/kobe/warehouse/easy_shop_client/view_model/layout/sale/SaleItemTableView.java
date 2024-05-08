package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.config.ApplicationConfigurer;
import com.kobe.warehouse.easy_shop_client.http.error.RemoteException;
import com.kobe.warehouse.easy_shop_client.http.error.ServerException;
import com.kobe.warehouse.easy_shop_client.http.service.sale.SaleService;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.ButtonUtils;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.Constant;
import com.kobe.warehouse.easy_shop_client.view_model.sale.CashSaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleLineModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Builder;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public class SaleItemTableView
    implements Builder<VBox> /*Builder<TableView<SaleLineModel>>*/ /*Callback<Pagination, VBox>*/ {
  private final TableView<SaleLineModel> tableView;
  private final Pagination pagination;
  private final int ROWS_PER_PAGE = ApplicationConfigurer.ROWS_PER_PAGE;
  private final SaleService saleService;
  private final ObjectProperty<SaleModel> saleModelObjectProperty;
  private final IntegerProperty totalItem;

  public SaleItemTableView(
      SaleService saleService, ObjectProperty<SaleModel> saleModelObjectProperty) {
    this.saleService = saleService;
    this.saleModelObjectProperty = saleModelObjectProperty;

    this.tableView = new TableView<>();
    this.tableView.setId("saleItemTableView");
    this.pagination = new Pagination();
    this.pagination.setId("saleItemPagination");
    this.totalItem = new SimpleIntegerProperty();
  }

  public Pagination getPagination() {
    return pagination;
  }

  public TableView<SaleLineModel> getTableView() {
    return tableView;
  }

  @Override
  public VBox build() {
    VBox vBox = new VBox();
    vBox.setPadding(new Insets(0, 0, 5, 5));
    vBox.setSpacing(2);
    // TODO: build TableView for SaleLineModel
    TableColumn<SaleLineModel, String> codeCipColumn = new TableColumn<>("Code CIP");
    codeCipColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
    codeCipColumn.setPrefWidth(100);
    // codeCipColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<SaleLineModel, String> libelleColumn = new TableColumn<>("Libelle");
    libelleColumn.setCellValueFactory(cellData -> cellData.getValue().produitLibelleProperty());
    libelleColumn.setPrefWidth(400);
    // codeCipColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<SaleLineModel, Integer> quantityRequestedColumn = new TableColumn<>("Qté.Demandée");
    quantityRequestedColumn.setPrefWidth(90);
    quantityRequestedColumn.setCellValueFactory(
        cellData -> cellData.getValue().quantityRequestedProperty().asObject());
    quantityRequestedColumn.setCellFactory(
        TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    quantityRequestedColumn.setOnEditCommit(
        event -> {
          SaleLineModel saleLineModel = event.getRowValue();
          saleLineModel.setQuantityRequested(event.getNewValue());
          try {

            if (saleModelObjectProperty.getValue() instanceof CashSaleModel cashSaleModel) {
              saleService.updateItemQtyRequested(saleLineModel);
            } else {
              saleService.updateItemQtyRequested(saleLineModel); // TODO : vente assurance
            }
          } catch (RemoteException | ServerException e) {
            if (e instanceof RemoteException) {
              ApplicationConfigurer.remoteException.setValue((RemoteException) e);
            } else {
              ApplicationConfigurer.serverException.setValue((ServerException) e);
            }
          }
          saleModelObjectProperty.set(saleService.findOne(saleLineModel.getSaleId()));
        });
    TableColumn<SaleLineModel, Integer> quantitySoldColumn = new TableColumn<>("Qté.Servie");
    quantitySoldColumn.setPrefWidth(90);
    quantitySoldColumn.setCellValueFactory(
        cellData -> cellData.getValue().quantitySoldProperty().asObject());
    quantitySoldColumn.setCellFactory(
        TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    quantitySoldColumn.setOnEditCommit(
        event -> {
          SaleLineModel saleLineModel = event.getRowValue();
          saleLineModel.setQuantitySold(event.getNewValue());
          try {
            if (saleModelObjectProperty.getValue() instanceof CashSaleModel cashSaleModel) {
              saleService.updateItemQtySold(saleLineModel);
            } else {
              saleService.updateItemQtySold(saleLineModel); // TODO : vente assurance
            }
          } catch (RemoteException | ServerException e) {
            if (e instanceof RemoteException) {
              ApplicationConfigurer.remoteException.setValue((RemoteException) e);
            } else {
              ApplicationConfigurer.serverException.setValue((ServerException) e);
            }
          }
          saleModelObjectProperty.set(saleService.findOne(saleLineModel.getSaleId()));
        });
    TableColumn<SaleLineModel, Integer> unitPriceColumn = new TableColumn<>("Prix.Unitaire");
    unitPriceColumn.setPrefWidth(100);
    unitPriceColumn.setCellValueFactory(
        cellData -> cellData.getValue().regularUnitPriceProperty().asObject());
    unitPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    unitPriceColumn.setOnEditCommit(
        event -> {
          SaleLineModel saleLineModel = event.getRowValue();
          saleLineModel.setRegularUnitPrice(event.getNewValue());
          SaleModel saleModel = saleModelObjectProperty.getValue();
          try {
            if (saleModel instanceof CashSaleModel cashSaleModel) {
              saleService.updateItemPrice(saleLineModel);

            } else {
              //  saleService.updateItemPrice(saleLineModel);
              //  saleModelObjectProperty.set(saleService.findOne(saleLineModel.getSaleId()));
            }

          } catch (RemoteException | ServerException e) {
            if (e instanceof RemoteException) {
              ApplicationConfigurer.remoteException.setValue((RemoteException) e);
            } else {
              ApplicationConfigurer.serverException.setValue((ServerException) e);
            }
          }
          saleModelObjectProperty.set(saleService.findOne(saleModel.getId()));
        });
    TableColumn<SaleLineModel, Integer> totalColumn = new TableColumn<>("Total");
    totalColumn.setPrefWidth(90);
    quantitySoldColumn.setCellValueFactory(
        cellData ->
            Bindings.createIntegerBinding(
                    () ->
                        cellData.getValue().getQuantitySold()
                            * cellData.getValue().getRegularUnitPrice(),
                    cellData.getValue().quantitySoldProperty(),
                    cellData.getValue().regularUnitPriceProperty())
                .asObject());

    TableColumn<SaleLineModel, Void> actionColumn = new TableColumn<>("");
    actionColumn.setPrefWidth(50);

    Callback<TableColumn<SaleLineModel, Void>, TableCell<SaleLineModel, Void>> cellFactory =
        new Callback<>() {
          @Override
          public TableCell<SaleLineModel, Void> call(final TableColumn<SaleLineModel, Void> param) {
            return new TableCell<>() {

              private final Button btn = buildButton();

              {
                btn.setOnAction(
                    (ActionEvent event) -> {
                      SaleLineModel saleLineModel = getTableView().getItems().get(getIndex());
                      SaleModel saleModel = saleModelObjectProperty.getValue();
                      try {
                        if (saleModel instanceof CashSaleModel cashSaleModel) {
                          saleService.deleteItemComptant(saleLineModel.getId());

                        } else {
                          saleService.deleteItem(saleLineModel.getId());
                        }
                      } catch (RemoteException | ServerException e) {
                        if (e instanceof RemoteException) {
                          ApplicationConfigurer.remoteException.setValue((RemoteException) e);
                        } else {
                          ApplicationConfigurer.serverException.setValue((ServerException) e);
                        }
                      }
                      saleModelObjectProperty.set(saleService.findOne(saleModel.getId()));
                    });
              }

              @Override
              public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                  setGraphic(null);
                } else {
                  setGraphic(btn);
                }
              }
            };
          }
        };

    actionColumn.setCellFactory(cellFactory);
    // int totalItems = httpService.getTotalItems(); // Implement this method in your service

    pagination
        .pageCountProperty()
        .bind(
            Bindings.createIntegerBinding(
                () ->
                    (saleModelObjectProperty
                                .map(SaleModel::getSalesLines)
                                .orElse(FXCollections.observableArrayList())
                                .getValue()
                                .size()
                            + ROWS_PER_PAGE
                            - 1)
                        / ROWS_PER_PAGE,
                saleModelObjectProperty.map(SaleModel::getSalesLines)));
    /* pagination.setPageFactory(
    pageIndex -> {
      /*  List<SaleLineModel> items =
      saleService.fetch(
          pageIndex * ROWS_PER_PAGE,
          ROWS_PER_PAGE); */
    // tableView.getItems().setAll(items);
    /*    return new VBox(tableView);
    });*/
    tableView
        .getColumns()
        .addAll(
            codeCipColumn,
            libelleColumn,
            quantityRequestedColumn,
            quantitySoldColumn,
            unitPriceColumn,
            totalColumn,
            actionColumn);
    tableView.setEditable(true);
    //
    // this.tableView.itemsProperty().bind(this.saleModelObjectProperty.map(SaleModel::getSalesLines));

    vBox.getChildren().setAll(buildSearchSegment(), tableView, pagination);

    /*
        pagination.setPageFactory(new Callback<Integer, Node>() {
        @Override
        public Node call(Integer pageIndex) {
            return new Label(pageIndex + 1 + ". Lorem ipsum dolor sit amet,\n"
                         + "consectetur adipiscing elit,\n"
                         + "sed do eiusmod tempor incididunt ut\n"
                         + "labore et dolore magna aliqua.");
        }
    });
         */

    return vBox;
  }

  /*
  @Override
  public VBox call(Pagination param) {

    int totalItems = httpService.getTotalItems(); // Implement this method in your service


    param.setPageCount((totalItems + ROWS_PER_PAGE - 1) / ROWS_PER_PAGE);

    param.setPageFactory(
        pageIndex -> {
          List<SaleLineModel> items =
              saleService.fetch(
                  pageIndex * ROWS_PER_PAGE,
                  ROWS_PER_PAGE); // Implement this method in your service
          tableView.getItems().setAll(items);
          return new VBox(tableView);
        });
    return new VBox(param);
  }*/

  private Button buildButton() {
    Button button = new Button();
    button.getStyleClass().setAll("btn", "btn-xs", "btn-danger");
    FontIcon iconButtonBtn = new FontIcon(FontAwesomeSolid.TRASH);
    iconButtonBtn.setIconSize(16);
    iconButtonBtn.setIconColor(Color.rgb(255, 255, 255));
    button.setGraphic(iconButtonBtn);
    button.setStyle(ButtonUtils.IN_LINE_STYLE_INFO);
    button.setOnMouseEntered(e -> button.setStyle(ButtonUtils.IN_LINE_STYLE_INFO_HOVER));
    button.setOnMouseExited(e -> button.setStyle(ButtonUtils.IN_LINE_STYLE_INFO));
    return button;
  }

  private TextField buildSearchSegment() {
    FilteredList<SaleLineModel> filteredList =
        new FilteredList<>(
            saleModelObjectProperty
                .map(SaleModel::getSalesLines)
                .orElse(new SimpleListProperty<>(FXCollections.observableArrayList()))
                .getValue(),
            p -> true);
    TextField textField = new TextField();
    textField.setPromptText(Constant.PRODUITS_FILRER);
    textField.setMinHeight(35);
    textField.setMaxWidth(300);

    /* Label textLable = new Label(Constant.PRODUITS);
    textLable.setStyle(Style.WR_LABEL);*/

    /*   HBox hBox = new HBox();
    hBox.setSpacing(5);
    hBox.setPadding(new Insets(0, 0, 5, 70));*/
    // Bind the FilteredList's predicate to the text property of the TextField
    //   this.tableView.itemsProperty().bind(filteredList.
    textField
        .textProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              filteredList.setPredicate(
                  saleLineModel -> {
                    // If the filter text is empty, display all items
                    if (newValue == null || newValue.isEmpty()) {
                      return true;
                    }

                    // Compare item's name with the filter text
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (saleLineModel.getCode().contains(lowerCaseFilter)
                        || saleLineModel
                            .getProduitLibelle()
                            .toLowerCase()
                            .contains(lowerCaseFilter)) {
                      return true; // Filter matches name
                    }

                    return false; // Does not match
                  });
            });
    tableView.setItems(filteredList);

    //  hBox.getChildren().addAll( textField);
    return textField;
  }
}
