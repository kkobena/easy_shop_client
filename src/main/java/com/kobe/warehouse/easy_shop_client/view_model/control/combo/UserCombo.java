package com.kobe.warehouse.easy_shop_client.view_model.control.combo;

import com.kobe.warehouse.easy_shop_client.config.ApplicationConfigurer;
import com.kobe.warehouse.easy_shop_client.http.response.UserInfo;
import com.kobe.warehouse.easy_shop_client.http.service.user.UserService;
import com.kobe.warehouse.easy_shop_client.http.service.user.UserServiceImpl;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Builder;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.controlsfx.control.SearchableComboBox;

public class UserCombo implements Builder<SearchableComboBox<UserInfo>> {
  private final UserService userService;
  private final SearchableComboBox<UserInfo> userInfoComboBox;
  private final ObjectProperty<UserInfo> selectedUser;

  public UserCombo(ObjectProperty<UserInfo> selectedUser) {
    this.selectedUser = selectedUser;
    this.userService = new UserServiceImpl();
    this.userInfoComboBox = new SearchableComboBox<>();
    this.userInfoComboBox.getStyleClass().add("wr-combo");
    this.userInfoComboBox.setPromptText("Veuiller choisir un vendeur");
    List<UserInfo> users = this.userService.fetchAll();
    this.userInfoComboBox.getItems().setAll(users);
    this.selectedUser.bind(this.userInfoComboBox.getSelectionModel().selectedItemProperty());

    userInfoComboBox.setCellFactory(
        new Callback<>() {
          @Override
          public ListCell<UserInfo> call(ListView<UserInfo> param) {
            return new ListCell<>() {
              @Override
              protected void updateItem(UserInfo item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                  setText(null);
                } else {
                  setText(item.getFullName());
                }
              }
            };
          }
        });

    // Set how to display the selected item in the ComboBox
    userInfoComboBox.setButtonCell(userInfoComboBox.getCellFactory().call(null));
    userInfoComboBox.setValue(ApplicationConfigurer.currentUser.getValue());

    // Set a custom StringConverter to convert between Person objects and strings
    userInfoComboBox.setConverter(
        new StringConverter<>() {
          @Override
          public String toString(UserInfo object) {
            return object != null ? object.getFullName() : null;
          }

          @Override
          public UserInfo fromString(String string) {
            // You can implement this method if needed
            return users.stream()
                .filter(u -> u.getFullName().contains(string))
                .findFirst()
                .orElse(null);
          }
        });
  }

  @Override
  public SearchableComboBox<UserInfo> build() {

    return this.userInfoComboBox;
  }
}
