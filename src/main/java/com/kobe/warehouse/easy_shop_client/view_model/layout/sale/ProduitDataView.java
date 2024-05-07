package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.view_model.produit.ProduitView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Builder;
import javafx.util.converter.IntegerStringConverter;

public class ProduitDataView implements Builder<TableView<ProduitView>> {
  private TableView<ProduitView> produitViewTableView;

  public ProduitDataView() {
    produitViewTableView = new TableView<>();

      TableColumn<ProduitView, String> firstNameCol = new TableColumn<>("First Name");
     // firstNameCol.setCellValueFactory(cellData -> cellData.getValue().getRegularUnitPrice());
      firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
      firstNameCol.setOnEditCommit(event -> {
          ProduitView person = event.getRowValue();
         // person.setFirstName(event.getNewValue());
      });

      TableColumn<ProduitView, String> lastNameCol = new TableColumn<>("Last Name");
     // lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
      lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
      lastNameCol.setOnEditCommit(event -> {
          ProduitView person = event.getRowValue();
       //   person.setLastName(event.getNewValue());
      });

      TableColumn<ProduitView, Integer> ageCol = new TableColumn<>("Age");
   //   ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
    ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
      ageCol.setOnEditCommit(event -> {
          ProduitView person = event.getRowValue();
          //person.setAge(event.getNewValue());
      });

      // Add columns to TableView
      produitViewTableView.getColumns().addAll(firstNameCol, lastNameCol, ageCol);
    //  produitViewTableView.getColumns().

      // Enable TableView editing
      produitViewTableView.setEditable(true);

  }

  @Override
  public TableView<ProduitView> build() {
    return produitViewTableView;
  }
}
