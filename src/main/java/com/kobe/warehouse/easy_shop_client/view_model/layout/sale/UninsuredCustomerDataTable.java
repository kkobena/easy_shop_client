package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.view_model.customer.UninsuredCustomer;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Builder;

public class UninsuredCustomerDataTable implements Builder<TableView<UninsuredCustomer>> {
  private TableView<UninsuredCustomer> produitViewTableView;

  public UninsuredCustomerDataTable() {
    this.produitViewTableView = new TableView<>();
    this.produitViewTableView.setMaxWidth(800.0);
  }

  @Override
  public TableView<UninsuredCustomer> build() {
    TableColumn<UninsuredCustomer, String> codeCol = new TableColumn<>("Code");
    codeCol.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
    codeCol.setPrefWidth(100);
    codeCol.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<UninsuredCustomer, String> firstName = new TableColumn<>("Nom");
    firstName.setPrefWidth(200);
    firstName.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    firstName.setCellFactory(TextFieldTableCell.forTableColumn());
    TableColumn<UninsuredCustomer, String> lastName = new TableColumn<>("Prénom");
    lastName.setPrefWidth(250);

    lastName.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    lastName.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<UninsuredCustomer, String> phone = new TableColumn<>("Téléphone");
    phone.setPrefWidth(250);
    phone.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
    phone.setCellFactory(TextFieldTableCell.forTableColumn());

    // Add columns to TableView
    produitViewTableView.getColumns().setAll(codeCol, firstName, lastName, phone);

    return produitViewTableView;
  }
}
