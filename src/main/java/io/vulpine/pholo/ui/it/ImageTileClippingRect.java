package io.vulpine.pholo.ui.it;

import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Rectangle;

public class ImageTileClippingRect extends Rectangle
{
  public ImageTileClippingRect(
    final DoubleProperty tileSize,
    final DoubleProperty arcSize
  ) {
    widthProperty().bind(tileSize);
    heightProperty().bind(tileSize);
    arcWidthProperty().bind(arcSize);
    arcHeightProperty().bind(arcSize);
  }
}
