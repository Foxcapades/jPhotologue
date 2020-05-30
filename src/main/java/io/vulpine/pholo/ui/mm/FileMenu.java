package io.vulpine.pholo.ui.mm;

import io.vulpine.pholo.co.mm.FileMenuController;
import io.vulpine.pholo.sv.Res;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class FileMenu extends Menu
{
  private final MenuItem settings;

  public FileMenu() {
    settings = new MenuItem(Res.get("menu.file.settings.text"));

    settings.setOnAction(FileMenuController::onSettingsAction);

    setText(Res.get("menu.file.text"));
    getItems().addAll(settings);
  }
}
