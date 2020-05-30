package io.vulpine.pholo.def;

import javafx.beans.property.DoubleProperty;

public interface GallerySettings
{
  DoubleProperty tileSize();

  DoubleProperty tilePadding();

  DoubleProperty tileRadius();
}
