package com.kobe.warehouse.easy_shop_client;

import com.kobe.warehouse.easy_shop_client.view_model.utils.MenuRegistry;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.SearchableComboBox;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class MainApplication extends Application {
  //  private @FXML Pane placeholderPane;
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main.fxml"));
    Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

    double x = bounds.getMinX() + (bounds.getWidth() - stage.getWidth()) / 2.0;
    double y = bounds.getMinY() + (bounds.getHeight() - stage.getHeight()) / 2.0;
    //  stage.setX(x);
    //  stage.setY(y);
    Scene scene = new Scene(fxmlLoader.load(), bounds.getWidth() / 1.02, bounds.getHeight() / 1.02);
    scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

    // Screen screen=Screen.getPrimary();
    //    button.getStyleClass().setAll("btn","btn-danger");
    stage.setTitle("Easy");

    stage.setScene(scene);

    this.show(stage, new Label("Easy"), StageStyle.DECORATED);
  }

  public static void main(String[] args) {
    MenuRegistry.registerMenu();
    launch();
  }

  private void show(Stage stage, Label styleLabel, StageStyle style) {
    // Set the text for the label to match the style
    styleLabel.setText(style.toString());
    // Set the style
    stage.initStyle(style);
    // For a transparent style, set the scene fill to null.
    // Otherwise, the content area will have the default white
    // background of the scene.
    if (style == StageStyle.TRANSPARENT) {
      stage.getScene().setFill(null);
      stage.getScene().getRoot().setStyle("-fx-background-color: transparent");
    } else if (style == StageStyle.UNIFIED) {
      stage.getScene().setFill(Color.TRANSPARENT);
    }
    // stage.initModality(Modality.WINDOW_MODAL);
    //  Node n1 = scene.lookup("#closeBtn");
    // Show the stage
    // EventHandler<MouseEvent> aHandler = e ->
    /*
            EventHandler<MouseEvent> mouseEventHandler =
    e -> System.out.println("Mouse event handler has been called.");
    // Register the MouseEvent filter and handler to the Circle
    // for mouse-clicked events
    circle.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventFilter);
    stage.sizeToScene()
    circle.setOnMouseClicked(eventHandler);
    public void handleAnyMouseEvent(MouseEvent e) {
    // Print a message only for mouse-clicked events,
    // ignoring other mouse events such as mouse-pressed,
    // mouse-released, etc.
    if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
    System.out.println(
    "MouseEvent.ANY handler detected a mouse click.");
    }
    }
    HBox root = new HBox(10);
    TextField nameFld = new TextField();
    // Let the TextField always grow horizontally
    root.setHgrow(nameFld, Priority.ALWAYS);
    To reset the hgrow priority of a child node, use null as the priority:
    // Stop the TextField from growing horizontally
    root.setHgrow(nameFld, null)
    root.setVgrow(desc, Priority.ALWAYS);
             */
    stage.show();
  }
}
