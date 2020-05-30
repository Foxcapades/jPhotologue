package io.vulpine.pholo.ui.iv;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ImageViewAnchor extends AnchorPane
{
  private final ImageView view;

  public ImageViewAnchor() {
    view = new ImageView();

    view.setPreserveRatio(true);
    view.setSmooth(true);

    setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    getChildren().add(view);
  }

  public void setImage( final String filePath ) {
    final Image img = new Image(filePath);

    if (img.isError()) {
      img.getException().printStackTrace();
    }

    view.setImage(img);
    view.setFitHeight(img.getHeight());
    view.setFitWidth(img.getWidth());
  }
}
