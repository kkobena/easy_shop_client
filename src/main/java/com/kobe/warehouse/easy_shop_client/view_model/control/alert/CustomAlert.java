package com.kobe.warehouse.easy_shop_client.view_model.control.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class CustomAlert extends Alert {

    public CustomAlert(AlertType alertType) {

        super(alertType);
    }

    public CustomAlert(AlertType alertType, String contentText, ButtonType... buttons) {
        super(alertType, contentText, buttons);
    }
}
