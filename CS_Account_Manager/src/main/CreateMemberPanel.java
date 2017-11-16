import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class CreateMemberPanel {

  String firstName, lastName, email, phoneNum, description;
  Label firstNameLabel, lastNameLabel, phoneNumLabel, emailLabel, descriptionLabel;
  TextField firstNameTField, lastNameTField, phoneNumTField, emailTField, descriptionTField;
  Button home, submit, logout;
  private LoginPanel lp = new LoginPanel();
  public CreateMemberPanel(){

}

  public Scene CreateMemberScene(Stage window){

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

      VBox space = new VBox();
      HBox layout1 = new HBox(50, firstNameLabel, firstNameTField);
      HBox layout2 = new HBox(50, lastNameLabel, lastNameTField);
      HBox layout3 = new HBox(24, phoneNumLabel, phoneNumTField);
      HBox layout4 = new HBox(83, emailLabel, emailTField);
      HBox layout5 = new HBox(45, descriptionLabel, descriptionTField);
      HBox layout6 = new HBox(55, home, submit, logout);

      VBox layout = new VBox(20, space, layout1, layout2, layout3, layout4, layout5, layout6);


    submit.setOnAction((event) -> {
      if(event.getSource() == submit){

        firstName = firstNameTField.getText();
        lastName =  lastNameTField.getText();
        email = emailTField.getText();
        phoneNum = phoneNumTField.getText();
        description = descriptionTField.getText();

        if (firstName.equals("")) {
          firstNameTField.setStyle("-fx-background-color: red;");
         }
         if (lastName.equals("")) {
           lastNameTField.setStyle("-fx-background-color: red;");
         }
         if (phoneNum.equals("")) {
           phoneNumTField.setStyle("-fx-background-color: red;");
         }
         if (email.equals("")) {
           emailTField.setStyle("-fx-background-color: red;");
         }
         if (description.equals("")) {
           descriptionTField.setStyle("-fx-background-color: red;");
         }
         if (firstName.equals("") || lastName.equals("") || phoneNum.equals("") || email.equals("")
           || description.equals("")) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Field Error!");
            alert.setHeaderText(null);
            alert.setContentText("Please Complete ALL Fields!");
            alert.showAndWait();
         } else {
           AccountMember myMember = new AccountMember(firstName, lastName, email, phoneNum, description);
           System.out.println(myMember);
           AccountsFrame.mainFile.addMember(myMember);
           System.out.println("submit");
        }
      }
   });

    home.setOnAction((event) -> {
        if(event.getSource() == home) {
            // window.setScene(hp.HomeScene(window));
        }
    });

    logout.setOnAction((event) -> {
        if(event.getSource() == logout) {
            window.setScene(lp.LoginScene(window));
        }
    });

    Scene createMember = new Scene(layout, 400, 400);

    return createMember;
  }

}
