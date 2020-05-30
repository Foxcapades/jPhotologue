package io.vulpine.pholo;

import io.vulpine.pholo.def.ScanResult;
import io.vulpine.pholo.sv.ImageScanner;
import io.vulpine.pholo.ui.RootNode;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Pholo extends Application
{
  @Override
  public void start( final Stage primaryStage ) throws Exception {
    final Task < ScanResult > task;
    final RootNode            stack;
    final Scene               scene;

    stack = RootNode.INSTANCE;
    scene = new Scene(stack);

    primaryStage.setWidth(1024);
    primaryStage.setHeight(768);
    primaryStage.setScene(scene);
    primaryStage.show();

    task = new ImageScanner(Paths.get("C:\\Users\\octon\\Pictures\\Wallpapers"));

    task.setOnSucceeded(t -> stack.getRootStack().container.getImageList().setImageList(task.getValue()
      .getUnknownResults()
      .stream()
      .map(path -> path.toAbsolutePath().toString())
      .map(path -> new Image("file:" + path, 256, 256, true, true, true))
      .collect(Collectors.toList())));
    task.setOnFailed(t -> task.getException().printStackTrace());

    new Thread(task).start();
  }
}
