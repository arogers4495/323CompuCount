import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class CreateMemberListener implements EventHandler<ActionEvent> {

 private String firstName, lastName, email, phoneNum, description;
 private Button submit;
 private AccountMember member;

 public CreateMemberListener(Button submit) {

  this.submit = submit;

 }

 @Override
 public void handle(ActionEvent event) {

  if (event.getSource() == submit) {

   firstName = CreateMemberScene.firstNameTField.getText().trim();
   lastName = CreateMemberScene.lastNameTField.getText().trim();
   email = CreateMemberScene.emailTField.getText().trim();
   phoneNum = CreateMemberScene.phoneNumTField.getText().trim();
   description = CreateMemberScene.descriptionTField.getText().trim();

   System.out.println(firstName);

   if (firstName.isEmpty() || lastName.isEmpty() || phoneNum.isEmpty() || email.isEmpty() || description.isEmpty()) {

    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Field Error!");
    alert.setHeaderText(null);
    alert.setContentText("Please Complete ALL Fields!");
    alert.showAndWait();
   } else {

    member = new AccountMember(firstName, lastName, phoneNum, email, description);

    try {
     AccountsFile.addMember(member);
    } catch (IOException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }

   }

   Alert alert = new Alert(AlertType.INFORMATION);
   alert.setTitle("Member Added!");
   alert.setHeaderText(null);
   alert.setContentText("Member Added!");
   alert.show();

   SceneController.ShowHome();

  }

 }

}
