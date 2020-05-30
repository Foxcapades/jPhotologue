package io.vulpine.pholo.ui.il;

import io.vulpine.pholo.ui.LeftDrag;
import io.vulpine.pholo.ui.RightDrag;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ImageViewRoot extends BorderPane
{
  public static final ImageViewRoot INSTANCE = new ImageViewRoot();

  private final ImageList imageList;

  private final StackPane imageViewStack;

  private final RightDrag < VBox > navMenus;

  private final LeftDrag < VBox > infoMenus;

  private ImageViewRoot() {
    imageList      = new ImageList();
    imageViewStack = new StackPane(makeScrollPane(imageList));
    navMenus       = new RightDrag <>(new VBox(new Label("Fooooops")));
    infoMenus      = new LeftDrag <>(new VBox(new Label("asdfasdfasdf")));

    setLeft(navMenus);
    setCenter(imageViewStack);
    setRight(infoMenus);
  }

  public ImageList getImageList() {
    return imageList;
  }

  private static ScrollPane makeScrollPane( final ImageList container ) {
    final ScrollPane pane = new ScrollPane(container);

    pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    container.prefWidthProperty().bind(pane.widthProperty().subtract(24));
    container.prefHeightProperty().bind(pane.heightProperty());

    return pane;
  }

}
