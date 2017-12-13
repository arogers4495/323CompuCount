import java.io.IOException;
import com.sun.java.swing.plaf.windows.resources.windows;
import javafx.application.Application;
import javafx.stage.Stage;

public class AccountMain extends Application {
    
    private SceneController controller;
    private static AccountsFile af;
    
 public static void main(String[] args) throws IOException {

     af = new AccountsFile();
     launch(args);
     
 }

@Override
public void start(Stage primaryStage) throws Exception {
    
    controller = new SceneController();
    SceneController.setStage(primaryStage);
    
    primaryStage.setTitle("CompuCount");
    SceneController.ShowHome();
    primaryStage.show();
    
    
}

}
