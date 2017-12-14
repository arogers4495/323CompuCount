
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class CreateMemberListener implements EventHandler<ActionEvent>{

    private String firstName, lastName, email, phoneNum, description;
    private Button submit;
    private AccountMember member;

    public CreateMemberListener(Button submit) {

        this.submit = submit;

    }

    @Override
    public void handle(ActionEvent event) {
      boolean emailCorrect = true;
      boolean phoneCorrect = true;
      int count1 = 0;
      int count2 = 0;
      char[] emailch;

        if(event.getSource() == submit) {

            firstName = CreateMemberScene.firstNameTField.getText().trim();
            lastName = CreateMemberScene.lastNameTField.getText().trim();
            email = CreateMemberScene.emailTField.getText().trim();
            phoneNum = CreateMemberScene.phoneNumTField.getText().trim();
            description = CreateMemberScene.descriptionTField.getText().trim();

            System.out.println(firstName);

            if (email.isEmpty() != true){
              emailch = email.toCharArray();
              for (int i = 0; i < emailch.length; i++){
                if (emailch[i] == '@'){
                  count1 += 1;
                }
                if (emailch[i] == '.'){
                  count2 += 1;
                }
              }
              if (count1 == 1 && count2 == 1){
                emailCorrect = true;
              }
              else{
                emailCorrect = false;
              }
            }
            if (emailCorrect == false){
              Alert alert = new Alert(AlertType.WARNING);
              alert.setTitle("Field Error!");
              alert.setHeaderText(null);
              alert.setContentText("Invalid Email");
              alert.showAndWait();
            }

            else if (phoneNum.isEmpty() != true){
              if (phoneNum.matches("^[0-9\\-]*$") && phoneNum.length() > 9){
                phoneCorrect = true;
              }
              else {
                phoneCorrect = false;
              }
            }
            if (phoneCorrect == false){
              Alert alert = new Alert(AlertType.WARNING);
              alert.setTitle("Field Error!");
              alert.setHeaderText(null);
              alert.setContentText("Invalid Phone Number");
              alert.showAndWait();
            }

            if (firstName.isEmpty() || lastName.isEmpty() || phoneNum.isEmpty()
                    || email.isEmpty() || description.isEmpty()){

                 Alert alert = new Alert(AlertType.WARNING);
                 alert.setTitle("Field Error!");
                 alert.setHeaderText(null);
                 alert.setContentText("Please Complete ALL Fields!");
                 alert.showAndWait();
                }
                else if (phoneCorrect && emailCorrect){

                  Alert alert = new Alert(AlertType.INFORMATION);
                  alert.setTitle("Member Added!");
                  alert.setHeaderText(null);
                  alert.setContentText("Member Added!");
                  alert.showAndWait();

                  member = new AccountMember(firstName, lastName, phoneNum,
                            email, description);

                  SceneController.ShowHome();

                 try {
                  AccountsFile.addMember(member);
                 } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                 }
                }
               }
        }
}
