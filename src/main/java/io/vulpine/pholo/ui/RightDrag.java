package io.vulpine.pholo.ui;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RightDrag < T extends Node > extends HBox
{
  private final T content;

  private final Rectangle rect;

  public RightDrag( final T content ) {
    rect = new Rectangle();
    rect.setWidth(2);
    rect.heightProperty().bind(heightProperty());
    rect.setCursor(Cursor.H_RESIZE);
    rect.setOnMouseDragged(this::onResizeDrag);
    rect.setOnMouseDragReleased(this::onDragRelease);
    rect.setFill(Color.rgb(200, 200, 200, 0.5));

    this.content = content;
    setHgrow(this.content, Priority.ALWAYS);
    getChildren().addAll(content, rect);
  }

  private void onDragRelease( final MouseDragEvent __ ) {
    prevX = -1;
    prevY = -1;
  }

  public T getContent() {
    return content;
  }

  private double prevX = -1;
  private double prevY = -1;

  public void onResizeDrag( final MouseEvent drag ) {
    final double x = drag.getX();
    final double y = drag.getY();

    if (prevX == -1) {
      prevX = x;
      prevY = y;
    }

    setPrefWidth(getWidth() + (x - prevX));
    setPrefHeight(getHeight() + (y - prevY));
  }
}
