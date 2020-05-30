package io.vulpine.pholo.ui.sm;

import io.vulpine.pholo.sv.Res;
import javafx.scene.control.Tab;

public class GalleryMenuTab extends Tab
{
  public GalleryMenuTab() {
    setText(Res.get("settings.gallery.tab.title"));
    setContent(new GalleryMenuTileSettings());
  }
}
