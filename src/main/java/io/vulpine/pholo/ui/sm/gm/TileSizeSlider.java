package io.vulpine.pholo.ui.sm.gm;

import io.vulpine.pholo.TempSettings;
import javafx.scene.control.Slider;

public class TileSizeSlider extends Slider
{
  public TileSizeSlider() {
    setMin(64D);
    setMax(256D);
    setMajorTickUnit(64D);
    setMinorTickCount(1);
    setShowTickMarks(true);
    setShowTickLabels(true);
    setSnapToTicks(true);
    valueProperty().bindBidirectional(TempSettings.TILE_SIZE);
  }
}
