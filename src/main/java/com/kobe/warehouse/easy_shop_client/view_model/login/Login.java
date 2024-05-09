package com.kobe.warehouse.easy_shop_client.view_model.login;

import com.kobe.warehouse.easy_shop_client.http.HttpService;
import com.kobe.warehouse.easy_shop_client.http.HttpServiceImpl;
import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.view_model.control.Style;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.ButtonUtils;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public class Login extends Application {
  private final HttpService httpService;

  public Login() {

    this.httpService = new HttpServiceImpl(UserInfo.class);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Formulaire de connection");

    primaryStage.initModality(Modality.APPLICATION_MODAL);
    primaryStage.initStyle(StageStyle.UTILITY);

    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setPadding(new Insets(10.0, 15.0, 10.0, 15.0));

    Label nameLabel = new Label("Login:");
    nameLabel.setStyle(Style.WR_LABEL);
    TextField nameInput = new TextField();
    nameInput.setMinHeight(30);
    nameInput.setMinWidth(250);
    nameInput.setPromptText("Entrer votre login");
    GridPane.setConstraints(nameLabel, 0, 0);
    GridPane.setConstraints(nameInput, 1, 0);
    gridPane.getChildren().addAll(nameLabel, nameInput);

    Label passLabel = new Label("Mot de passe:");
    passLabel.setStyle(Style.WR_LABEL);
    PasswordField passInput = new PasswordField();
    passInput.setMinHeight(30);
    passInput.setMinWidth(250);
    passInput.setPromptText("Entrer votre mot de passe");
    GridPane.setConstraints(passLabel, 0, 1);
    GridPane.setConstraints(passInput, 1, 1);
    nameInput.setOnKeyPressed(
        e -> {
          if (e.getCode() == KeyCode.ENTER
              && (authenticate(nameInput.getText(), passInput.getText()))) {
            primaryStage.close();
          }
        });
    passInput.setOnKeyPressed(
        e -> {
          if (e.getCode() == KeyCode.ENTER
              && (authenticate(nameInput.getText(), passInput.getText()))) {
            primaryStage.close();
          }
        });

    gridPane.getChildren().addAll(passLabel, passInput);

    Button loginButton = new Button("Se connecter");
    FontIcon iconButton = new FontIcon(FontAwesomeSolid.SIGN_IN_ALT);
    iconButton.setIconSize(16);
    iconButton.setIconColor(Color.rgb(255, 255, 255));
    loginButton.setGraphic(iconButton);
    loginButton.setStyle(ButtonUtils.IN_LINE_STYLE_INFO);
    loginButton.setOnMouseEntered(e -> loginButton.setStyle(ButtonUtils.IN_LINE_STYLE_INFO_HOVER));

    loginButton.setOnMouseExited(e -> loginButton.setStyle(ButtonUtils.IN_LINE_STYLE_INFO));
    loginButton.setOnAction(
        e -> {
          try {
            if (authenticate(nameInput.getText(), passInput.getText())) {
              primaryStage.close();
            }

          } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, "Erreur de connexion", ButtonType.OK).showAndWait();
          }
        });

    loginButton
        .disableProperty()
        .bind(nameInput.textProperty().isEmpty().or(passInput.textProperty().isEmpty()));

    GridPane.setConstraints(loginButton, 1, 2);
    GridPane.setHalignment(loginButton, HPos.CENTER);
    gridPane.getChildren().add(loginButton);

    VBox vBox = new VBox();
    var icon = new FontIcon(FontAwesomeSolid.LOCK_OPEN);
    icon.setIconSize(24);

    VBox.setMargin(icon, new Insets(5, 0, 10, 350));
    VBox.setVgrow(icon, Priority.NEVER);
    VBox.setVgrow(gridPane, Priority.ALWAYS);

    vBox.getChildren().setAll(icon, gridPane);
    Scene scene = new Scene(vBox, 400, 170);

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private boolean authenticate(String login, String password) {
    if (!login.isEmpty() && !password.isEmpty()) {
      try {
        this.httpService.authenticate(login, password);
        return true;
      } catch (Exception e) {
        new Alert(Alert.AlertType.ERROR, "Erreur de connexion", ButtonType.OK).showAndWait();
        return false;
      }
    }
    return false;
  }
}
