package io.vulpine.pholo;

import io.vulpine.pholo.def.ScanResult;

import java.nio.file.Path;
import java.util.*;

public class SimpleScanResult implements ScanResult
{
  private final Map < UUID, Path > knownFiles;

  private final Set < Path > newFiles;

  public SimpleScanResult(
    final Map < UUID, Path > knownFiles,
    final Set < Path > newFiles
  ) {
    this.knownFiles = knownFiles;
    this.newFiles = newFiles;
  }

  public SimpleScanResult() {
    this(new HashMap <>(), new HashSet <>());
  }

  @Override
  public Map < UUID, Path > getKnownResults() {
    return knownFiles;
  }

  @Override
  public Set < Path > getUnknownResults() {
    return newFiles;
  }
}
