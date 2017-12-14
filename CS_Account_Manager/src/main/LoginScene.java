import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class LoginScene {

    Label unameLabel;
    Label pwdLabel;
    static Label lPrompt;
    static TextField unameTField;
    static PasswordField pwdField;
    Button login;
    LoginListener ll;

    
    public LoginScene() {
    
        
    
    }

    public Scene getLoginScene(){
    
    lPrompt = new Label("");
    unameLabel = new Label("Username: ");
    pwdLabel = new Label("Password: ");
    login = new Button("Login");
    unameTField = new TextField();
    pwdField = new PasswordField();
    
    login.setFont(new Font("Arial", 15));
       
    BorderPane bp = new BorderPane();
    
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    grid.add(lPrompt, 1, 0);
    grid.add(unameLabel, 0, 1);
    grid.add(unameTField, 1, 1);
    grid.add(pwdLabel, 0, 2);
    grid.add(pwdField, 1, 2);
    
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    hbBtn.getChildren().add(login);
    grid.add(hbBtn, 1, 4);   
    
    bp.setCenter(grid);
    
    Scene loginScene = new Scene(bp, 500, 250);
    
    ll = new LoginListener(login);
    
    login.setOnAction(ll);
    
    return loginScene;
    
}

}

