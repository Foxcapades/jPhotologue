package io.vulpine.pholo.ui.iv;

import javafx.scene.control.ScrollPane;

public class ImageViewContainer extends ScrollPane
{
  private final ImageViewAnchor anchor;

  public ImageViewContainer() {
    anchor = new ImageViewAnchor();

    anchor.prefWidthProperty().bind(widthProperty());
    anchor.prefHeightProperty().bind(heightProperty());

    setPannable(true);
    setContent(anchor);
  }

  public void setImage( final String filePath ) {
    anchor.setImage(filePath);
  }
}
