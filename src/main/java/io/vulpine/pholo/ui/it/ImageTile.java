package io.vulpine.pholo.ui.it;

import io.vulpine.pholo.TempSettings;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ImageTile extends Pane
{
  private final Image image;

  public ImageTile( final Image imageView ) {

    image = imageView;

    setClip(new ImageTileClippingRect(
      TempSettings.TILE_SIZE,
      TempSettings.TILE_RADIUS
    ));

    setBorder(new Border(new BorderStroke(
      Color.valueOf("#333"),
      BorderStrokeStyle.SOLID,
      new CornerRadii(10),
      new BorderWidths(1)
    )));

    setPadding(new Insets(TempSettings.TILE_PADDING.doubleValue()));
    setBackground(makeBackground());
    setOpacity(0.85);

    setOnMouseEntered(e -> {
      setCursor(Cursor.HAND);
      setOpacity(1);
    });

    setOnMouseExited(e -> {
      setCursor(Cursor.DEFAULT);
      setOpacity(0.85);
    });
  }

  private Background makeBackground() {
    final BackgroundImage bgImage = new BackgroundImage(
      image,
      BackgroundRepeat.NO_REPEAT,
      BackgroundRepeat.NO_REPEAT,
      BackgroundPosition.CENTER,
      BackgroundSize.DEFAULT
    );

    return new Background(bgImage);
  }

  public Image getImage() {
    return image;
  }
}
