package com.kobe.warehouse.easy_shop_client.view_model.control.combo;

import com.kobe.warehouse.easy_shop_client.view_model.NatureVente;
import java.util.Arrays;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Builder;
import javafx.util.Callback;

public class NatureVenteCombo implements Builder<ComboBox<NatureVente>> {

  private final ComboBox<NatureVente> comboBox;
  private final ObjectProperty<NatureVente> selectedNatureVente;

  public NatureVenteCombo(ObjectProperty<NatureVente> selectedNatureVente) {
    this.selectedNatureVente = selectedNatureVente;

    this.comboBox = new ComboBox<>();
    this.comboBox.getStyleClass().add("wr-combo");
    // this.userInfoComboBox.setEditable(true);
    List<NatureVente> natureVentes = Arrays.stream(NatureVente.values()).toList();
    this.comboBox.getItems().setAll(natureVentes);
    this.selectedNatureVente.bind(this.comboBox.getSelectionModel().selectedItemProperty());
    comboBox.setCellFactory(
        new Callback<>() {
          @Override
          public ListCell<NatureVente> call(ListView<NatureVente> param) {
            return new ListCell<>() {
              @Override
              protected void updateItem(NatureVente item, boolean empty) {
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
  }

  @Override
  public ComboBox<NatureVente> build() {
    this.comboBox.setValue(NatureVente.COMPTANT);
    return this.comboBox;
  }
}
