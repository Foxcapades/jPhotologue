package io.vulpine.pholo.ui.sm;

import io.vulpine.pholo.sv.Res;
import io.vulpine.pholo.ui.sm.gm.TileRadiusSlider;
import io.vulpine.pholo.ui.sm.gm.TileSizeSlider;
import io.vulpine.pholo.ui.sm.gm.TileSpacingSlider;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GalleryMenuTileSettings extends VBox
{
  private final Label header;

  private final GridPane options;

  private final Label tileSizeLabel;
  private final Slider tileSizeSlider;

  private final Label tileSpacingLabel;
  private final Slider tileSpacingSlider;

  private final Label tileCornerRadiusLabel;
  private final Slider tileCornerRadiusSlider;

  public GalleryMenuTileSettings() {
    header = new Label(Res.get("settings.gallery.tiles.title"));
    options = new GridPane();

    tileSizeLabel = new Label(Res.get("settings.gallery.tiles.size"));
    tileSizeSlider = new TileSizeSlider();

    tileSpacingLabel = new Label(Res.get("settings.gallery.tiles.space"));
    tileSpacingSlider = new TileSpacingSlider();

    tileCornerRadiusLabel = new Label(Res.get("settings.gallery.tiles.radius"));
    tileCornerRadiusSlider = new TileRadiusSlider();

    options.add(tileSizeLabel, 0, 0);
    options.add(tileSizeSlider, 1, 0);
    options.add(tileSpacingLabel, 0, 1);
    options.add(tileSpacingSlider, 1, 1);
    options.add(tileCornerRadiusLabel, 0, 2);
    options.add(tileCornerRadiusSlider, 1, 2);

    this.getChildren().addAll(header, options);
  }
}
