package io.vulpine.pholo.sv;

import io.vulpine.pholo.def.ResourceManager;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Res implements ResourceManager
{
  private final static Res INSTANCE = new Res();
  private final static Pattern REPLACE = Pattern.compile("\\{([^}\\s]+)}");

  private final ResourceBundle bundle;


  private Res() {
    bundle = ResourceBundle.getBundle("pilo");
  }

  private String parse( final String value ) {
    final StringBuffer out;
    final Matcher      mat;

    if ( value.isEmpty() )
      return value;

    mat = REPLACE.matcher(value);
    out = new StringBuffer();

    while ( mat.find() ) {
      final String cur = mat.group(1);
      mat.appendReplacement(
        out,
        bundle.containsKey(cur)
          ? bundle.getString(cur)
          : mat.group(0)
      );
    }

    return out.length() == 0 ? value : out.toString();
  }

  @Override
  public String getString( final String key ) {
    return parse(bundle.getString(key));
  }

  public static String get( final String key ) {
    return getInstance().getString(key);
  }

  public static Res getInstance() { return INSTANCE; }
}
