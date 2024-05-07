package com.kobe.warehouse.easy_shop_client.view_model.control.progress;

import javafx.beans.property.*;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Skin;

public class CustomProgress extends Control {
  public CustomProgress() {
  //  getStyleClass().add("masker-pane");
    setStyle(Style.ROOT);
  }

  /**************************************************************************
   *
   * Properties
   *
   **************************************************************************/

  // -- Background Color

  // -- Progress
  private final DoubleProperty progress =
      new SimpleDoubleProperty(this, "progress", -1.0); // $NON-NLS-1$

  public final DoubleProperty progressProperty() {
    return progress;
  }

  public final double getProgress() {
    return progress.get();
  }

  public final void setProgress(double progress) {
    this.progress.set(progress);
  }

  // -- Progress Node
  private final ObjectProperty<Node> progressNode =
      new SimpleObjectProperty<>() {
        {
          ProgressIndicator node = new ProgressIndicator();
          node.progressProperty().bind(progress);
          setValue(node);
        }

        @Override
        public String getName() {
          return "progressNode";
        } //$NON-NLS-1$

        @Override
        public Object getBean() {
          return CustomProgress.this;
        }
      };

  public final ObjectProperty<Node> progressNodeProperty() {
    return progressNode;
  }

  public final Node getProgressNode() {
    return progressNode.get();
  }

  public final void setProgressNode(Node progressNode) {
    this.progressNode.set(progressNode);
  }

  // -- Progress Visibility
  private final BooleanProperty progressVisible =
      new SimpleBooleanProperty(this, "progressVisible", true); // $NON-NLS-1$

  public final BooleanProperty progressVisibleProperty() {
    return progressVisible;
  }

  public final boolean getProgressVisible() {
    return progressVisible.get();
  }

  public final void setProgressVisible(boolean progressVisible) {
    this.progressVisible.set(progressVisible);
  }

  private final StringProperty text =
      new SimpleStringProperty(this, "text", "Traitement en cours..."); // $NON-NLS-1$

  public final StringProperty textProperty() {
    return text;
  }

  public final String getText() {
    return text.get();
  }

  public final void setText(String text) {
    this.text.set(text);
  }

  @Override
  protected Skin<?> createDefaultSkin() {
    return new CustomProgressSkin(this);
  }
}
