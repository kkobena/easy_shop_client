package com.kobe.warehouse.easy_shop_client.view_model.control.progress;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class CustomProgressSkin  extends SkinBase<CustomProgress> {
    /**
     * Constructor for all SkinBase instances.
     *
     * @param customProgress The control for which this Skin should attach to.
     */
    public CustomProgressSkin(CustomProgress customProgress) {
        super(customProgress);
        getChildren().add(createMasker(customProgress));
    }



    private StackPane createMasker(CustomProgress customProgress) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10.0);
        vBox.getStyleClass().add("masker-center"); //$NON-NLS-1$
        vBox.setStyle(Style.CENTER);
        vBox.getChildren().add(createLabel());
        vBox.getChildren().add(createProgressIndicator());

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(vBox);

        StackPane glass = new StackPane();
        glass .setStyle(Style.GLASS);
        glass.setAlignment(Pos.CENTER);
        glass.getStyleClass().add("masker-glass"); //$NON-NLS-1$
        glass.getChildren().add(hBox);

        return glass;
    }

    private Label createLabel() {
        Label text = new Label();
        text.textProperty().bind(getSkinnable().textProperty());
        text.getStyleClass().add("masker-text"); //$NON-NLS-1$
        text.setStyle(Style.TEXT);
        return text;
    }

    private Label createProgressIndicator() {
        Label graphic = new Label();
        graphic.setGraphic(getSkinnable().getProgressNode());
        graphic.visibleProperty().bind(getSkinnable().progressVisibleProperty());
        graphic.getStyleClass().add("masker-graphic"); //$NON-NLS-1$
        return graphic;
    }
}
