package io.vulpine.pholo.def;

import javafx.collections.ObservableList;

import java.nio.file.Path;

public interface AppSettings
{
  ObservableList < Path > watchedDirectories();

  GallerySettings gallerySettings();
}
