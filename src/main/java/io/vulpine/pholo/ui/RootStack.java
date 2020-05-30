package io.vulpine.pholo.ui;

import io.vulpine.pholo.ui.il.ImageViewRoot;
import javafx.scene.layout.StackPane;

public class RootStack extends StackPane
{
  public static final RootStack INSTANCE = new RootStack();

  public final ImageViewRoot container = ImageViewRoot.INSTANCE;

  private RootStack() {
    getChildren().add(container);
  }

}
