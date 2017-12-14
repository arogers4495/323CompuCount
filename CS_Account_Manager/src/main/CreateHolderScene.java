import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class CreateHolderScene {

    private Label firstNameLabel, lastNameLabel, usernameLabel, passwordLabel, poweredBy, CreateLabel;
    static TextField firstNameTField, lastNameTField, usernameTField, passwordTField;
    private Button home, submit, logout;
    private AccountMember myMember;
    private CreateHolderListener chl;
    private BorderListener bl;
    private HBox hb, hbox, hbox1;
    private BorderPane bpane;
    
    
    public CreateHolderScene() {
        
    }

    public Scene getHolderScene() {
        
        CreateLabel = new Label("Create Account Holder");
        
        CreateLabel.setFont(new Font("Arial", 20));
        
        firstNameLabel = new Label("First Name:");
        lastNameLabel = new Label("Last Name:");
        usernameLabel = new Label("Username:");
        passwordLabel = new Label("Password:");

        firstNameTField = new TextField();
        lastNameTField = new TextField();
        usernameTField = new TextField();
        passwordTField = new TextField();
        
        submit = new Button("Submit");
        submit.setFont(new Font("Arial", 15));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        hbox = new HBox();
        hbox.setAlignment(Pos.TOP_LEFT);
        hbox.getChildren().add(CreateLabel);
        
        hb = new HBox();
        hb.setAlignment(Pos.BOTTOM_RIGHT);
        hb.getChildren().add(submit);

        
        grid.add(hbox, 1, 0);
        grid.add(firstNameLabel, 0, 1);
        grid.add(firstNameTField, 1, 1);
        grid.add(lastNameLabel, 0, 2);
        grid.add(lastNameTField, 1, 2);
        grid.add(usernameLabel, 0, 3);
        grid.add(usernameTField, 1, 3);
        grid.add(passwordLabel, 0, 4);
        grid.add(passwordTField, 1, 4);
        grid.add(hb, 1, 5);
        
        chl = new CreateHolderListener(submit);
        
        submit.setOnAction(chl);
        
        Scene CreateholderScene = new Scene(grid, 400, 300);

        return CreateholderScene;
       }
            
}
