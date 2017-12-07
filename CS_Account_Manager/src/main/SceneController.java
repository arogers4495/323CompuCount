import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SceneController {

 private static LoginScene ls;
 private static HomeScene hs;
 private static ViewAccountScene vas;
 private static CreateMemberScene cms;
 private static Stage window;

 public SceneController() throws IOException {
  ls = new LoginScene();
  hs = new HomeScene();
  vas = new ViewAccountScene();
  cms = new CreateMemberScene();
  window = new Stage();
 }

 public static void ShowLogin() {

  window.setScene(ls.LoginScene());
 }

 public static void ShowViewAccountScene() {

  window.setScene(vas.ViewMember());
 }

 public static void ShowCreateMember() {

  window.setScene(cms.CreateScene());
 }

 public void setStage(Stage primaryStage) {

  window = primaryStage;

 }

 public static void showHome() {
  window.setScene(hs.HomeScene());
 }

}
