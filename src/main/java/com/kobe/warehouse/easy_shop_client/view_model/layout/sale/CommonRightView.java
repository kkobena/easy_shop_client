package com.kobe.warehouse.easy_shop_client.view_model.layout.sale;

import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Remise;
import com.kobe.warehouse.easy_shop_client.view_model.NatureVente;
import com.kobe.warehouse.easy_shop_client.view_model.TypePrescription;
import com.kobe.warehouse.easy_shop_client.view_model.control.combo.NatureVenteCombo;
import com.kobe.warehouse.easy_shop_client.view_model.control.combo.RemiseCombo;
import com.kobe.warehouse.easy_shop_client.view_model.control.combo.TypePrescriptionCombo;
import com.kobe.warehouse.easy_shop_client.view_model.control.combo.UserCombo;
import com.kobe.warehouse.easy_shop_client.view_model.utils.SalesCommonUtils;
import javafx.beans.property.ObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.SearchableComboBox;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class CommonRightView implements Builder<VBox> {
  private final VBox vBox;
/*
  private final ComboBox<TypePrescription> typePrescriptionComboBox =
      SalesCommonUtils.TYPE_PRESCIPTION_COMBO;*/
  // private final ComboBox<NatureVente> natureVenteComboBox = SalesCommonUtils.NATURE_VENET_COMBO;
  private final ObjectProperty<UserInfo> selectedUser;
  private final ObjectProperty<NatureVente> selectedNatureVente;
  private final ObjectProperty<TypePrescription> selectedTypePrescription;
  private final ObjectProperty<Remise> selectedRemise;

  public CommonRightView(
          ObjectProperty<UserInfo> selectedUser,
          ObjectProperty<NatureVente> selectedNatureVente, ObjectProperty<TypePrescription> selectedTypePrescription,
          ObjectProperty<Remise> selectedRemise) {
    this.selectedUser = selectedUser;
    this.selectedNatureVente = selectedNatureVente;
      this.selectedTypePrescription = selectedTypePrescription;
      this.selectedRemise = selectedRemise;
    this.vBox = new VBox();
    this.vBox.setSpacing(8);
    this.vBox.setPadding(new Insets(3));
    this.vBox.setPrefWidth(280);
    vBox.setFillWidth(true);
    this.vBox.getStyleClass().setAll("main_pane_content_item", "common_right_view");
  }

  @Override
  public VBox build() {
    SearchableComboBox<UserInfo> userComboBox = new UserCombo(this.selectedUser).build();
    ComboBox<NatureVente> natureVenteComboBox =
        new NatureVenteCombo(this.selectedNatureVente).build();

   ComboBox<TypePrescription> typePrescriptionComboBox =
            new TypePrescriptionCombo(this.selectedTypePrescription).build();

    Panel paneluserCombo = new Panel();
    VBox.setVgrow(paneluserCombo, Priority.NEVER);
    paneluserCombo.getStyleClass().add("panel-default");

    // paneluserCombo.getStyleClass().add("panel-primary");
    //  paneluserCombo.setPadding(new Insets(5));
    paneluserCombo.setText("Vendeurs");
    userComboBox.setPrefSize(270, 30);
    paneluserCombo.setBody(userComboBox);
    Panel panelTypePrescriptionCombo = new Panel();
    VBox.setVgrow(panelTypePrescriptionCombo, Priority.NEVER);
    panelTypePrescriptionCombo.getStyleClass().add("panel-default");
    //  panelTypePrescriptionCombo.setPadding(new Insets(5));
    panelTypePrescriptionCombo.setText("Nature vente");
   typePrescriptionComboBox.setPrefSize(270, 30);
    panelTypePrescriptionCombo.setBody(typePrescriptionComboBox);
    Panel panelNatureVenteComboBox = new Panel();
    VBox.setVgrow(panelNatureVenteComboBox, Priority.NEVER);


    panelNatureVenteComboBox.getStyleClass().add("panel-default");
    // panelNatureVenteComboBox.setPadding(new Insets(5));
    panelNatureVenteComboBox.setText("Type de vente ");
    natureVenteComboBox.setPrefSize(270, 30);
    panelNatureVenteComboBox.setBody(natureVenteComboBox);

    ComboBox<Remise> remiseComboBox = new RemiseCombo().build();
    remiseComboBox.setPromptText("Veuillez selectionner une remise");
    this.selectedRemise.bind(remiseComboBox.getSelectionModel().selectedItemProperty());
    Panel panelRemise = new Panel();
    VBox.setVgrow(panelRemise, Priority.NEVER);
    panelRemise.getStyleClass().add("panel-default");

    // paneluserCombo.getStyleClass().add("panel-primary");
    //  paneluserCombo.setPadding(new Insets(5));
    panelRemise.setText("Remises");
    panelRemise.setPrefSize(270, 30);
    panelRemise.setBody(remiseComboBox);

    this.vBox
        .getChildren()
        .setAll(paneluserCombo, panelNatureVenteComboBox, panelRemise, panelTypePrescriptionCombo);
    return this.vBox;
  }
}
