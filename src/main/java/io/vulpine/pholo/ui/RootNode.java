package io.vulpine.pholo.ui;

import io.vulpine.pholo.ui.mm.MainMenu;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class RootNode extends VBox
{
  public final static RootNode INSTANCE = new RootNode();

  private final MainMenu mainMenu;

  private final RootStack rootStack;

  private RootNode() {
    mainMenu  = MainMenu.INSTANCE;
    rootStack = RootStack.INSTANCE;

    setVgrow(rootStack, Priority.ALWAYS);

    getChildren().addAll(mainMenu, rootStack);
  }

  public MainMenu getMainMenu() {
    return mainMenu;
  }

  public RootStack getRootStack() {
    return rootStack;
  }
}
