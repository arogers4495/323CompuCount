import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CreateMemberScene {

 String firstName, lastName, email, phoneNum, description;
 Label firstNameLabel, lastNameLabel, phoneNumLabel, emailLabel, descriptionLabel, poweredBy;
 TextField firstNameTField, lastNameTField, phoneNumTField, emailTField, descriptionTField;
 Button home, submit, logout;
 AccountMember myMember;
 CreateMemberListener cml;
 
 public CreateMemberScene() {

     
     
     
 }

 public Scene CreateMemberScene() {

  BorderPane bp = new BorderPane();

  poweredBy = new Label("Powered By 4Guys");

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

  home = new Button("Home");
  logout = new Button("Logout");
  submit = new Button("Submit");



  GridPane grid = new GridPane();
  grid.setAlignment(Pos.CENTER);
  grid.setHgap(10);
  grid.setVgap(10);
  grid.setPadding(new Insets(5, 5, 5, 5));


  grid.add(firstNameLabel, 0, 0);
  grid.add(firstNameTField, 1, 0);
  grid.add(lastNameLabel, 0, 1);
  grid.add(lastNameTField, 1, 1);
  grid.add(emailLabel, 0, 2);
  grid.add(emailTField, 1, 2);
  grid.add(phoneNumLabel, 0, 3);
  grid.add(phoneNumTField, 1, 3);
  grid.add(descriptionLabel, 0, 4);
  grid.add(descriptionTField, 1, 4);

  grid.add(home, 0, 6);
  grid.add(submit, 1, 6);
  grid.add(logout, 2, 6);

  cml = new CreateMemberListener(submit);
  
  submit.setOnAction((event) -> {
   if (event.getSource() == submit) {

    firstName = firstNameTField.getText();
    lastName = lastNameTField.getText();
    email = emailTField.getText();
    phoneNum = phoneNumTField.getText();
    description = descriptionTField.getText();

    if (firstName.equals("") || lastName.equals("") || phoneNum.equals("") || email.equals("")
      || description.equals("")) {

     Alert alert = new Alert(AlertType.WARNING);
     alert.setTitle("Field Error!");
     alert.setHeaderText(null);
     alert.setContentText("Please Complete ALL Fields!");
     alert.showAndWait();
    } else {
     myMember = new AccountMember(firstName, lastName, email, phoneNum, description);
     try {
      AccountsFile.addMember(myMember);
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
     System.out.println(myMember);
     System.out.println("submit");
    }
   }
  });

  home.setOnAction((event) ->

  {
   if (event.getSource() == home) {
    SceneController.ShowHome();
   }
  });

  logout.setOnAction((event) -> {
   if (event.getSource() == logout) {
    SceneController.ShowLogin();
   }
  });

  bp.setCenter(grid);
  bp.setBottom(poweredBy);

  Scene createMember = new Scene(bp, 400, 400);

  return createMember;
 }

}
