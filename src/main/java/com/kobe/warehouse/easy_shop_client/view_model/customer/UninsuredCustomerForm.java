package com.kobe.warehouse.easy_shop_client.view_model.customer;

import com.kobe.warehouse.easy_shop_client.http.service.customer.UninsuredCustomerService;
import com.kobe.warehouse.easy_shop_client.http.service.customer.UninsuredCustomerServiceImpl;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.Add;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.ButtonUtils;
import com.kobe.warehouse.easy_shop_client.view_model.control.button.Constant;
import com.kobe.warehouse.easy_shop_client.view_model.control.progress.CustomProgress;
import com.kobe.warehouse.easy_shop_client.view_model.control.text.NumberTextField;
import com.kobe.warehouse.easy_shop_client.view_model.control.text.WrTextField;
import java.util.Objects;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import net.synedra.validatorfx.Validator;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public class UninsuredCustomerForm extends Dialog<UninsuredCustomer> {
  private UninsuredCustomer uninsuredCustomer;
  private final UninsuredCustomerService uninsuredCustomerService;
  private BooleanProperty isSave = new SimpleBooleanProperty(false);

  public UninsuredCustomerForm(UninsuredCustomer uninsuredCustomer) {
    this.uninsuredCustomerService = new UninsuredCustomerServiceImpl();
    CustomProgress customProgress = new CustomProgress();
    customProgress.setVisible(false);

    isSave.addListener((observable, oldValue, newValue) -> customProgress.setVisible(newValue));
    initModality(Modality.APPLICATION_MODAL);
    initStyle(StageStyle.UTILITY);
    if (Objects.isNull(uninsuredCustomer)) {
      //    this.uninsuredCustomer = new UninsuredCustomer();

      setHeaderText(Constant.AJOUT_CLIENT_FORM_TITLE);
    } else {
      this.uninsuredCustomer = uninsuredCustomer;

      setHeaderText(
          String.format(
              Constant.MODIFICATION_CLIENT_FORM_TITLE, this.uninsuredCustomer.getFullName()));
    }
    Validator validator = new Validator();

    var icon = new FontIcon(FontAwesomeSolid.USERS);
    icon.setIconSize(24);
    setGraphic(icon);

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(10.0, 20.0, 10.0, 20.0));
    TextField firstName = new WrTextField().build();
    firstName.setMinWidth(300);
    firstName.setPromptText("Nom");
    validator
        .createCheck()
        .dependsOn("firstName", firstName.textProperty())
        .withMethod(
            c -> {
              String v = c.get("firstName");
              if (v.isEmpty()) {
                c.error(Constant.REQUIRED_FIELD);
              }
            })
        .decorates(firstName)
        .immediate();

    TextField lastName = new WrTextField().build();
    lastName.setPromptText("Prénom(s)");
    validator
        .createCheck()
        .dependsOn("lastName", lastName.textProperty())
        .withMethod(
            c -> {
              String v = c.get("lastName");
              if (v.isEmpty()) {
                c.error(Constant.REQUIRED_FIELD);
              }
            })
        .decorates(lastName)
        .immediate();
    lastName.setMinWidth(300);

    TextField phone = new NumberTextField().build();
    validator
        .createCheck()
        .dependsOn("phone", phone.textProperty())
        .withMethod(
            c -> {
              String v = c.get("phone");
              if (v.isEmpty()) {
                c.error(Constant.REQUIRED_FIELD);
              }
            })
        .decorates(phone)
        .immediate();
    phone.setMinWidth(300);
    phone.setPromptText("Téléphone");

    TextField email = new WrTextField().build();
    email.setMinWidth(300);
    email.setPromptText("Email");
    Label nom = new Label(Constant.FIRSNAME);
    Label emailLabel = new Label(Constant.EMAIL);
    grid.add(nom, 0, 0);
    grid.add(firstName, 1, 0);
    Label prenom = new Label(Constant.LASTNAME);
    grid.add(prenom, 0, 1);
    grid.add(lastName, 1, 1);
    Label phoneLable = new Label(Constant.PHONE);
    grid.add(phoneLable, 0, 2);
    grid.add(phone, 1, 2);
    grid.add(emailLabel, 0, 3);
    grid.add(email, 1, 3);
    HBox btns = new HBox();
    btns.setPadding(new Insets(2.0, 2.0, 3.0, 20.0));
    btns.setSpacing(5.0);
    Button add = new Add(FontAwesomeSolid.USER.getDescription(), Constant.BTN_ADD_CUSTMER).build();

    add.disableProperty()
        .bind(
            firstName
                .textProperty()
                .isEmpty()
                .or(lastName.textProperty().isEmpty())
                .or(phone.textProperty().isEmpty()));

    add.setOnAction(
        event -> {
          // isSave.set(true);
          if (Objects.isNull(this.uninsuredCustomer)) {
            this.uninsuredCustomer = new UninsuredCustomer();
            populateUninsuredCustomer(
                firstName.getText(), lastName.getText(), email.getText(), phone.getText());

            this.uninsuredCustomer = post(this.uninsuredCustomer);
          } else {
            populateUninsuredCustomer(
                firstName.getText(), lastName.getText(), email.getText(), phone.getText());
            this.uninsuredCustomer = this.put(this.uninsuredCustomer);
          }

          //  isSave.set(false);

          setResult(this.uninsuredCustomer);
          event.consume();
        });

    add.setStyle(ButtonUtils.IN_LINE_STYLE_INFO);
    add.setOnMouseEntered(e -> add.setStyle(ButtonUtils.IN_LINE_STYLE_INFO_HOVER));

    // Normal state style again when mouse exits
    add.setOnMouseExited(e -> add.setStyle(ButtonUtils.IN_LINE_STYLE_INFO));

    Button cancel = new Add(FontAwesomeSolid.TRASH.getDescription(), Constant.CANCEL_BTN).build();
    cancel.setId("cutstmerCancelBtn");

    cancel.setStyle(ButtonUtils.IN_LINE_STYLE_CANCEL);
    cancel.setOnMouseEntered(e -> cancel.setStyle(ButtonUtils.IN_LINE_STYLE_CANCEL));

    // Normal state style again when mouse exits
    cancel.setOnMouseExited(e -> cancel.setStyle(ButtonUtils.IN_LINE_STYLE_CANCEL_HOVER));
    btns.getChildren().setAll(add, cancel);
    grid.add(btns, 1, 4);

    /*
        (0, 0)	(1, 0)	(2, 0)
    (2, 1)	(1, 1)	(0, 1)
    (2, 2)	(1, 2)	(0, 2)

         */
    /*
    init form
     */

    if (Objects.nonNull(this.uninsuredCustomer)) {
      firstName.setText(this.uninsuredCustomer.getFirstName());
      lastName.setText(this.uninsuredCustomer.getLastName());
      phone.setText(this.uninsuredCustomer.getPhone());
      email.setText(this.uninsuredCustomer.getEmail());
    }

    StackPane body = new StackPane();

    //   body.getChildren().addAll(grid, new CircleProgress().build());
    body.getChildren().addAll(grid, customProgress);
    getDialogPane().setContent(body);
  }

  private UninsuredCustomer post(UninsuredCustomer uninsuredCustomer) {
    return this.uninsuredCustomerService.add(uninsuredCustomer);
  }

  private UninsuredCustomer put(UninsuredCustomer uninsuredCustomer) {
    return this.uninsuredCustomerService.update(uninsuredCustomer);
  }

  private void populateUninsuredCustomer(
      String firstName, String lastName, String email, String phone) {
    this.uninsuredCustomer.setFirstName(firstName);
    this.uninsuredCustomer.setLastName(lastName);
    this.uninsuredCustomer.setEmail(email);
    this.uninsuredCustomer.setPhone(phone);
  }
}
