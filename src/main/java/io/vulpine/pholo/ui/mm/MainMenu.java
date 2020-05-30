package io.vulpine.pholo.ui.mm;

import javafx.scene.control.MenuBar;

public class MainMenu extends MenuBar
{
  public static final MainMenu INSTANCE = new MainMenu();

  private final FileMenu fileMenu;

  private MainMenu() {
    fileMenu = new FileMenu();

    this.getMenus().addAll(fileMenu);
  }
}
