package io.vulpine.pholo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class TempSettings
{
  public static final DoubleProperty TILE_PADDING = new SimpleDoubleProperty(10);
  public static final DoubleProperty TILE_SIZE    = new SimpleDoubleProperty(128);
  public static final DoubleProperty TILE_RADIUS  = new SimpleDoubleProperty(20);
}
