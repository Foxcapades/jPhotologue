package io.vulpine.pholo.ui.sm;

import javafx.scene.control.TabPane;

public class SettingsMenuGroup extends TabPane
{
  private final GalleryMenuTab galleryMenuTab;

  public SettingsMenuGroup() {
    galleryMenuTab = new GalleryMenuTab();

    this.getTabs().add(galleryMenuTab);
  }
}
