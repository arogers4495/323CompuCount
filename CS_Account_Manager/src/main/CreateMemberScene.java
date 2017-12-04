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
 BorderListener bl;
 HBox hb;

 public CreateMemberScene() {

 }

 public Scene CreateScene() {

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

  GridPane grid = new GridPane();
  grid.setAlignment(Pos.CENTER);
  grid.setHgap(10);
  grid.setVgap(10);
  grid.setPadding(new Insets(5, 5, 5, 5));

  hb = new HBox();
  hb.setAlignment(Pos.BOTTOM_RIGHT);
  hb.getChildren().add(submit);

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
  grid.add(hb, 1, 5);

  firstName = firstNameTField.getText();
  lastName = lastNameTField.getText();
  email = emailTField.getText();
  phoneNum = phoneNumTField.getText();
  description = descriptionTField.getText();

  myMember = new AccountMember(firstName, lastName, email, phoneNum, description);

  cml = new CreateMemberListener(submit, myMember);

  submit.setOnAction(cml);

  Scene CreateMemberScene = new Scene(getFinallayout(grid), 500, 500);

  return CreateMemberScene;
 }

 public BorderPane getFinallayout(GridPane grid) {

  HBox hbox, hbox1;
  BorderPane bpane;
  Button logout, home;
  Label poweredBy;

  logout = new Button("Logout");
  home = new Button("Home");
  poweredBy = new Label("4Guys");

  logout = new Button("Logout");
  home = new Button("Home");
  poweredBy = new Label("4Guys");

  bpane = new BorderPane();
  hbox = new HBox();
  hbox1 = new HBox();

  hbox.getChildren().addAll(home, logout);
  hbox1.getChildren().add(poweredBy);

  hbox1.setAlignment(Pos.BOTTOM_RIGHT);
  hbox.setAlignment(Pos.TOP_RIGHT);

  bpane.setTop(hbox);
  bpane.setBottom(hbox1);

  bl = new BorderListener(logout, home);

  logout.setOnAction(bl);
  home.setOnAction(bl);

  bpane.setCenter(grid);

  return bpane;

 }

}
