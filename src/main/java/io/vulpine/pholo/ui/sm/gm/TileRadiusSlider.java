package io.vulpine.pholo.ui.sm.gm;

import io.vulpine.pholo.TempSettings;
import javafx.scene.control.Slider;

public class TileRadiusSlider extends Slider
{
  public TileRadiusSlider() {
    setMin(0D);
    setMax(512D);
    setMajorTickUnit(20D);
    setMinorTickCount(9);
    setShowTickMarks(true);
    setShowTickLabels(true);
    setSnapToTicks(true);
    valueProperty().bindBidirectional(TempSettings.TILE_RADIUS);
  }
}
