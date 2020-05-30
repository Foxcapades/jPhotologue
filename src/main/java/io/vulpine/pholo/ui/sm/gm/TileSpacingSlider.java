package io.vulpine.pholo.ui.sm.gm;

import io.vulpine.pholo.TempSettings;
import javafx.scene.control.Slider;

public class TileSpacingSlider extends Slider
{
  public TileSpacingSlider() {
    setMin(2D);
    setMax(80D);
    setMajorTickUnit(10D);
    setMinorTickCount(4);
    setShowTickMarks(true);
    setShowTickLabels(true);
    setSnapToTicks(true);
    valueProperty().bindBidirectional(TempSettings.TILE_PADDING);
  }
}
