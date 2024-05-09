package com.kobe.warehouse.easy_shop_client.view_model.control.alert;

import javafx.scene.control.Alert;

public class ErrorAlert {
    public ErrorAlert() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("L'enregistrement a échoué");
        alert.setContentText("Veuillez vérifier vos saisies et réessayer");
        alert.showAndWait();
    }
}
