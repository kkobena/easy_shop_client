package com.kobe.warehouse.easy_shop_client.view_model.control.combo;

import com.kobe.warehouse.easy_shop_client.http.service.sale.RemiseService;
import com.kobe.warehouse.easy_shop_client.http.service.sale.RemiseServiceImpl;
import com.kobe.warehouse.easy_shop_client.view_model.TypePrescription;
import java.util.Arrays;
import java.util.List;

import com.kobe.warehouse.easy_shop_client.http.response.sale.Remise;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Builder;
import javafx.util.Callback;

public class RemiseCombo implements Builder<ComboBox<Remise>> {

  private final ComboBox<Remise> comboBox;
  private final RemiseService remiseService;

  public RemiseCombo() {
    this.remiseService = new RemiseServiceImpl();
    this.comboBox = new ComboBox<>();
    this.comboBox.getStyleClass().add("wr-combo");


  }

  @Override
  public ComboBox<Remise> build() {
    this.comboBox.getItems().setAll(this.remiseService.fetch());
    comboBox.setCellFactory(
        new Callback<>() {
          @Override
          public ListCell<Remise> call(ListView<Remise> param) {
            return new ListCell<>() {
              @Override
              protected void updateItem(Remise item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                  setText(null);
                } else {
                  setText(item.getValeur());
                }
              }
            };
          }
        });

    comboBox.setButtonCell(comboBox.getCellFactory().call(null));
    return this.comboBox;
  }
}
