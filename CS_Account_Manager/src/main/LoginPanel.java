import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class LoginPanel {

    Label unameLabel, poweredBy;
    Label pwdLabel;
    TextField unameTField;
    PasswordField pwdField;
    Button login;
    String usernameInput;
    String passwordInput;
    String usernameActual;
    String passwordActual = "csci323";
    HomePanel hp;
    
public LoginPanel(){
    
}

public Scene LoginScene(Stage window){
    
    unameLabel = new Label("Username: ");
    pwdLabel = new Label("Password: ");
    login = new Button("Login");
    unameTField = new TextField();
    pwdField = new PasswordField();
    poweredBy = new Label("Powered By 4Guys");
    
    hp = new HomePanel();
    
    // username and password for testing purposes
    usernameActual = "csadmin";
    
    BorderPane bp = new BorderPane();
    
    
    
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    
    grid.add(unameLabel, 0, 1);
    grid.add(unameTField, 1, 1);
    grid.add(pwdLabel, 0, 2);
    grid.add(pwdField, 1, 2);
    
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    hbBtn.getChildren().add(login);
    grid.add(hbBtn, 1, 4);   
    
    bp.setCenter(grid);
    bp.setBottom(poweredBy);
    
    Scene loginScene = new Scene(bp, 500, 250);
    
    login.setOnAction((event) -> {
        if(event.getSource() == login) {
            
            String uname = unameTField.getText();
            String pwd = pwdField.getText();
            
            if(uname.equals(usernameActual) && pwd.equals(passwordActual)) {
                
                window.setScene(hp.HomeScene(window));
                
            }
            
        }
    });
    
    return loginScene;
    
}

}
