package com.kobe.warehouse.easy_shop_client.view_model.control.combo.experimental;

import javafx.beans.binding.Bindings;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Skin;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseButton;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class AutoCompletePopupSkin<T> implements Skin<AutoCompletePopup<T>> {

  private final AutoCompletePopup<T> control;
  private final ListView<T> suggestionList;
 // private final  StringConverter<T> displayConverter;
  final int LIST_CELL_HEIGHT = 24;

 public AutoCompletePopupSkin(AutoCompletePopup<T> control) {
    this(control, control.getConverter());
  }

  /**
   * @param control The popup to be skinned
   * @param displayConverter An alternate {@link StringConverter} to use. This way, you can show
   *     autocomplete suggestions that when applied will fill in a different text than displayed.
   *     For example, you may preview {@code Files.newBufferedReader(Path: path) - Bufferedreader}
   *     but only fill in {@code Files.newBufferedReader(}
   */
 public AutoCompletePopupSkin(AutoCompletePopup<T> control, StringConverter<T> displayConverter) {
    this(control, TextFieldListCell.forListView(displayConverter));
  }

  /**
   * @param control The popup to be skinned
   * @param cellFactory Set a custom cell factory for the suggestions.
   */
  public AutoCompletePopupSkin(
      AutoCompletePopup<T> control, Callback<ListView<T>, ListCell<T>> cellFactory) {
    this.control = control;
    suggestionList = new ListView<>(control.getSuggestions());

    suggestionList.setMinWidth(460.0);
   // suggestionList.setMinHeight(70);

    suggestionList.getStyleClass().add(AutoCompletePopup.DEFAULT_STYLE_CLASS);

    /**
     * Here we bind the prefHeightProperty to the minimum height between the max visible rows and
     * the current items list. We also add an arbitrary 5 number because when we have only one item
     * we have the vertical scrollBar showing for no reason.
     */
   suggestionList
        .prefHeightProperty()
        .bind(
            Bindings.max(
                    control.visibleRowCountProperty(), Bindings.size(suggestionList.getItems()))
                .multiply(LIST_CELL_HEIGHT).add(50)
                );

    suggestionList.setCellFactory(cellFactory);


    // Allowing the user to control ListView width.
   // suggestionList.prefWidthProperty().bind(control.prefWidthProperty());
  //  suggestionList.maxWidthProperty().bind(control.maxWidthProperty());
   // suggestionList.minWidthProperty().bind(control.minWidthProperty());
    registerEventListener();
  }

  private void registerEventListener() {
    suggestionList.setOnMouseClicked(
        me -> {
          if (me.getButton() == MouseButton.PRIMARY) {
            onSuggestionChoosen(suggestionList.getSelectionModel().getSelectedItem());
          }
        });

    suggestionList.setOnKeyPressed(
        ke -> {
          switch (ke.getCode()) {
            case TAB:
            case ENTER:
              onSuggestionChoosen(suggestionList.getSelectionModel().getSelectedItem());
              break;
            case ESCAPE:
              if (control.isHideOnEscape()) {
                control.hide();
              }
              break;
            default:
              break;
          }
        });
  }

  private void onSuggestionChoosen(T suggestion) {
    if (suggestion != null) {
      Event.fireEvent(control, new AutoCompletePopup.SuggestionEvent<>(suggestion));
    }
  }

  @Override
  public Node getNode() {
    return suggestionList;
  }

  @Override
  public AutoCompletePopup<T> getSkinnable() {
    return control;
  }

  @Override
  public void dispose() {}

    public ListView<T> getSuggestionList() {
        return suggestionList;
    }
}
