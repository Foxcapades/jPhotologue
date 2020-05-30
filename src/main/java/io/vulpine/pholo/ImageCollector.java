package io.vulpine.pholo;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.sun.imageio.plugins.png.PNGMetadata;
import io.vulpine.pholo.def.ScanResult;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.imageio.*;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

public class ImageCollector implements FileVisitor < Path >
{
  private final ScanResult result;

  public ImageCollector() {
    result = new SimpleScanResult();
  }

  public ScanResult fetchResults() {
    return result;
  }

  @Override
  public FileVisitResult preVisitDirectory(
    final Path dir,
    final BasicFileAttributes attrs
  ) throws
    IOException { return FileVisitResult.CONTINUE; }

  @Override
  public FileVisitResult visitFile( final Path file, final BasicFileAttributes attrs ) throws IOException {
    if ( !attrs.isRegularFile() ) { return FileVisitResult.CONTINUE; }

    final String asString  = file.toAbsolutePath().toString();
    final String extension = asString.substring(asString.lastIndexOf('.') + 1)
      .toLowerCase();

    if ( extension.equals("bmp")
      || extension.equals("gif")
      || extension.equals("png")
      || extension.equals("jpg") || extension.equals("jpeg")
      ) {
      FACE(file);
      result.getUnknownResults().add(file);
    }

    return FileVisitResult.CONTINUE;
  }

  public void FACE( final Path file ) throws IOException {
    final ImageReader      reader;
    final IIOMetadata      metadata;
    final ImageInputStream iis;

    iis    = ImageIO.createImageInputStream(new BufferedInputStream(new FileInputStream(file.toFile())));
    reader = ImageIO.getImageReadersByFormatName("png").next();

    reader.setInput(iis, true);
    metadata = reader.getImageMetadata(0);

    final IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(IIOMetadataFormatImpl.standardMetadataFormatName);
    final NodeList entries = root.getElementsByTagName("TextEntry");

    for ( int i = 0; i < entries.getLength(); i++ ) {
      IIOMetadataNode node = (IIOMetadataNode) entries.item(i);
      System.out.println("node.getAttribute(\"keyword\") = " + node.getAttribute("keyword"));
      System.out.println("node.getAttribute(\"value\") = " + node.getAttribute("value"));
    }
  }

  private void FUCK( final Path file ) throws IOException {
    final ImageWriter writer = ImageIO.getImageWritersByFormatName("png")
      .next();

    final BufferedImage img = ImageIO.read(file.toFile());

    final ImageWriteParam writeParam = writer.getDefaultWriteParam();
    final ImageTypeSpecifier typeSpecifier
      = ImageTypeSpecifier.createFromBufferedImageType(
      BufferedImage.TYPE_INT_RGB);

    final IIOMetadata metadata = writer.getDefaultImageMetadata(
      typeSpecifier,
      writeParam
    );

    final IIOMetadataNode textEntry = new IIOMetadataNode("tEXtEntry");

    textEntry.setAttribute("keyword", "comment");
    textEntry.setAttribute("value", "DERP DERP DERP");

    final IIOMetadataNode text = new IIOMetadataNode("tEXt");
    text.appendChild(textEntry);

    final IIOMetadataNode root = new IIOMetadataNode("javax_imageio_png_1.0");
    root.appendChild(text);

    metadata.mergeTree("javax_imageio_png_1.0", root);

    final FileOutputStream baos
      = new FileOutputStream(new File(file.toString() + "dddd"));
    final ImageOutputStream stream = ImageIO.createImageOutputStream(baos);

    writer.setOutput(stream);
    writer.write(metadata, new IIOImage(img, null, metadata), writeParam);

    stream.close();
  }

  @Override
  public FileVisitResult visitFileFailed(
    final Path file,
    final IOException exc
  ) throws IOException { return FileVisitResult.CONTINUE; }

  @Override
  public FileVisitResult postVisitDirectory(
    final Path dir,
    final IOException exc
  ) throws IOException { return FileVisitResult.CONTINUE; }


}
