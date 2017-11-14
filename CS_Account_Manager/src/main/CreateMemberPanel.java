import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CreateMemberPanel {

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
        if (firstNameTField.equals("")) {
             firstNameTField.setStyle("-fx-background-color: red;");
           }
           if (lastNameTField.equals("")) {
             lastNameTField.setStyle("-fx-background-color: red;");
           }
           if (phoneNumTField.equals("")) {
             phoneNumTField.setStyle("-fx-background-color: red;");
           }
           if (emailTField.equals("")) {
             emailTField.setStyle("-fx-background-color: red;");
           }
           if (descriptionTField.equals("")) {
             descriptionTField.setStyle("-fx-background-color: red;");
           }
           if (firstNameTField.equals("") || lastNameTField.equals("") || phoneNumTField.equals("") || emailTField.equals("")
             || descriptionTField.equals("")) {
            JOptionPane.showMessageDialog(null, "Please complete ALL fields");
           } else {
            System.out.println("submit");
          }
    }
   });
    
    home.setOnAction((event) -> {
        if(event.getSource() == home) {
            
            //window.setScene(hp.HomeScene(window));
            
        }
    });
    
    logout.setOnAction((event) -> {
        if(event.getSource() == logout) {
            
            window.setScene(lp.LoginScene(window));
            
        }
    });
    
    Scene createMember = new Scene(layout, 500, 500);

    return createMember;
  }

}
