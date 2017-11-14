import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AccountFrame extends Application {

 public static void main(String[] args) throws IOException {

  launch(args);

 }

@Override
public void start(Stage window) throws Exception {
    
    LoginPanel lp = new LoginPanel();
    CreateMemberPanel cmp = new CreateMemberPanel();
    HomePanel hp = new HomePanel();
    ViewAccountMember vam = new ViewAccountMember();
    
    window.setTitle("CS AccountManager");
    window.setScene(lp.LoginScene(window));
    window.show();
    
}

}
