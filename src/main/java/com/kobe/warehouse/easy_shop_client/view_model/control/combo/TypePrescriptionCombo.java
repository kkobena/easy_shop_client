package com.kobe.warehouse.easy_shop_client.view_model.control.combo;

import com.kobe.warehouse.easy_shop_client.view_model.TypePrescription;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Builder;
import javafx.util.Callback;

import java.util.Arrays;
import java.util.List;

public class TypePrescriptionCombo implements Builder<ComboBox<TypePrescription>> {

  private final ComboBox<TypePrescription> comboBox;

  public TypePrescriptionCombo() {

    this.comboBox = new ComboBox<>();
    this.comboBox.getStyleClass().add("wr-combo");
    // this.userInfoComboBox.setEditable(true);
    List<TypePrescription> typePrescriptions = Arrays.stream(TypePrescription.values()).toList();
    this.comboBox.getItems().setAll(typePrescriptions);
    comboBox.setCellFactory(
        new Callback<>() {
          @Override
          public ListCell<TypePrescription> call(ListView<TypePrescription> param) {
            return new ListCell<>() {
              @Override
              protected void updateItem(TypePrescription item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                  setText(null);
                } else {
                  setText(item.getValue());
                }
              }
            };
          }
        });

    comboBox.setButtonCell(comboBox.getCellFactory().call(null));
    comboBox.setValue(TypePrescription.PRESCRIPTION);

  }

  @Override
  public ComboBox<TypePrescription> build() {

    return this.comboBox;
  }
}
