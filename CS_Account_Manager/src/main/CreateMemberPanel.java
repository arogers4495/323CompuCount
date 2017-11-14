

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CreateMemberPanel  {

 private Label firstNameLabel, lastNameLabel, phoneNumLabel, emailLabel, descriptionLabel;
 private TextField firstNameTField, lastNameTField, phoneNumTField, emailTField, descriptionTField;
 private Button submit, home;
 private String firstName, lastName, phoneNum, email, description;
 private HomePanel hp;
 public AccountsFile af;

 public CreateMemberPanel() {

  firstNameLabel = new Label("First Name:");
  lastNameLabel = new Label("Last Name:");
  phoneNumLabel = new Label("Phone Number:");
  emailLabel = new Label("Email:");
  descriptionLabel = new Label("Description:");

  firstNameTField = new TextField();
  lastNameTField = new TextField();
  phoneNumTField = new TextField();
  emailTField = new TextField();
  descriptionTField = new TextField();

  submit = new Button("Submit");
  home = new Button("Home");

  
 }
 
 public Scene CMScene(Stage window) {
     
     GridPane grid = new GridPane();
     grid.setAlignment(Pos.CENTER);
     grid.setHgap(10);
     grid.setVgap(10);
     grid.setPadding(new Insets(25, 25, 25, 25));
     
     grid.add(firstNameLabel, 0, 1);
     grid.add(lastNameLabel, 0, 2);
     grid.add(phoneNumLabel, 0, 3);
     grid.add(emailLabel, 0, 4);
     grid.add(descriptionLabel, 0, 5);
     
     grid.add(firstNameTField, 1, 1);
     grid.add(lastNameTField, 1, 2);
     grid.add(phoneNumTField, 1, 3);
     grid.add(emailTField, 1, 4);
     grid.add(descriptionTField, 1, 5);
     
     HBox hbBtn1 = new HBox(10);
     hbBtn1.setAlignment(Pos.TOP_LEFT);
     hbBtn1.getChildren().add(home);
     grid.add(hbBtn1, 0, 0);
     
     HBox hbBtn = new HBox(10);
     hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
     hbBtn.getChildren().add(submit);
     grid.add(hbBtn, 2, 6);
     
     home.setOnAction((event) -> {
         hp = new HomePanel();
         
         if(event.getSource() == home){
             
             window.setScene(hp.HomeScene(window));
             
         }
         
     });
     
     submit.setOnAction((event) -> {
         
         if(event.getSource() == submit){
             
             if(firstNameTField.getText().equals(null) || lastNameTField.getText().equals(null) || phoneNumTField.getText().equals(null) || emailTField.getText().equals(null) || descriptionTField.getText().equals(null)){
                 
             }
             
         }
         
     });
     
     Scene CMScene = new Scene(grid, 500, 500);
     
     return CMScene;
 }


}
