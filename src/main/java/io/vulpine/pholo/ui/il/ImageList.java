package io.vulpine.pholo.ui.il;

import io.vulpine.pholo.ui.it.ImageTile;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.List;

public class ImageList extends TilePane
{
  private final DoubleProperty tileSize = new SimpleDoubleProperty(128);

  private final FilteredList < ImageTile > filteredList;

  private final SortedList < ImageTile > sortedList;

  private final ObservableList < ImageTile > fullList;

  public ImageList() {
    fullList     = FXCollections.observableArrayList();
    sortedList   = new SortedList <>(fullList);
    filteredList = new FilteredList <>(sortedList);

    filteredList.addListener((ListChangeListener < ImageTile >) c -> {
      getChildren().clear();
      getChildren().addAll(filteredList);
    });

    setHgap(10);
    setVgap(10);
    setPadding(new Insets(10));
    prefTileHeightProperty().bind(tileSize);
    prefTileWidthProperty().bind(tileSize);
  }

  public void setImageList(final List < Image > data) {
    fullList.clear();

    data.forEach(iv -> fullList.add(new ImageTile(iv)));
  }
}
