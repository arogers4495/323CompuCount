import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class CreateMemberListener implements EventHandler<ActionEvent>{

    private Button submit;
    private AccountMember member;
    
    public CreateMemberListener(Button submit, AccountMember member) {
        
        this.submit = submit;
        this.member = member;
        
    }

    @Override
    public void handle(ActionEvent event) {
        
        if(event.getSource() == submit) {

                if (member.firstName.equals("") || member.lastName.equals("") || member.phone.equals("") || member.email.equals("")
                  || member.description.equals("")) {

                 Alert alert = new Alert(AlertType.WARNING);
                 alert.setTitle("Field Error!");
                 alert.setHeaderText(null);
                 alert.setContentText("Please Complete ALL Fields!");
                 alert.showAndWait();
                } else {
                 try {
                  AccountsFile.addMember(member);
                 } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                 }
                 System.out.println(member);
                 System.out.println("submit");
                }
               }
            
        }

}
