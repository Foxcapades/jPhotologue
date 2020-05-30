package io.vulpine.pholo.sv;

import io.vulpine.pholo.ImageCollector;
import io.vulpine.pholo.def.ScanResult;
import javafx.concurrent.Task;

import java.nio.file.Files;
import java.nio.file.Path;

public class ImageScanner extends Task < ScanResult >
{
  private final Path path;

  public ImageScanner( final Path path ) {
    this.path = path;
  }

  @Override
  protected ScanResult call() throws Exception {
    final ImageCollector collector = new ImageCollector();

    Files.walkFileTree(path, collector);

    return collector.fetchResults();
  }
}
