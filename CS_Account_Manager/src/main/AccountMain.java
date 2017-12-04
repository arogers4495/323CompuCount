import java.io.IOException;
import com.sun.java.swing.plaf.windows.resources.windows;
import javafx.application.Application;
import javafx.stage.Stage;

public class AccountMain extends Application {

 private SceneController controller;

 public static void main(String[] args) throws IOException {

  launch(args);

 }

 @Override
 public void start(Stage primaryStage) throws Exception {

  controller = new SceneController();
  SceneController.setStage(primaryStage);

  primaryStage.setTitle("CompuCount");
  SceneController.ShowCreateMember();
  primaryStage.show();

 }

}
