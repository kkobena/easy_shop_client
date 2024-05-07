package com.kobe.warehouse.easy_shop_client.view_model.control;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Builder;
import javafx.util.Duration;

public class CircleProgress implements Builder<StackPane> {
  private static final double PROGRESS_RADIUS = 20;
  private static final double STROKE_WIDTH = 6;
  private static final double ANIMATION_DURATION = 1;

  private Circle createCircle(double radius, Color strokeColor, Color fillColor) {
    Circle circle = new Circle(radius);
    circle.setStroke(strokeColor);
    circle.setFill(fillColor);
    circle.setStrokeWidth(STROKE_WIDTH);
    return circle;
  }

  @Override
  public StackPane build() {
    Circle backgroundCircle = createCircle(PROGRESS_RADIUS, Color.LIGHTGRAY, Color.TRANSPARENT);

    Circle progressCircle = createCircle(PROGRESS_RADIUS, Color.web("#5bc0de"), Color.TRANSPARENT);
    StackPane root = new StackPane();
    root.getChildren().addAll(backgroundCircle, progressCircle);
    Timeline timeline =
        new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(progressCircle.radiusProperty(), 0)),
            new KeyFrame(
                Duration.seconds(ANIMATION_DURATION),
                new KeyValue(progressCircle.radiusProperty(), PROGRESS_RADIUS)));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
    return root;
  }
}
