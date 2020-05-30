package io.vulpine.pholo.def;

import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface ScanResult
{
  Map < UUID, Path > getKnownResults();

  Set < Path > getUnknownResults();
}
