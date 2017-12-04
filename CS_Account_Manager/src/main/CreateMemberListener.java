import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class CreateMemberListener implements EventHandler<ActionEvent>{

    private Button submit;
    private AccountMember member;
    
    public CreateMemberListener(Button submit) {
        
        this.submit = submit;
        
    }

    @Override
    public void handle(ActionEvent event) {
        
        if(event.getSource() == submit) {

            System.out.println(CreateMemberScene.firstName);
            
                if (CreateMemberScene.firstName.isEmpty() || CreateMemberScene.lastName.isEmpty() || CreateMemberScene.phoneNum.isEmpty()
                    || CreateMemberScene.email.isEmpty() || CreateMemberScene.description.isEmpty()) {
                    
                 Alert alert = new Alert(AlertType.WARNING);
                 alert.setTitle("Field Error!");
                 alert.setHeaderText(null);
                 alert.setContentText("Please Complete ALL Fields!");
                 alert.showAndWait();
                } else {
                    
                    member = new AccountMember(CreateMemberScene.firstName, CreateMemberScene.lastName, CreateMemberScene.phoneNum,
                            CreateMemberScene.email, CreateMemberScene.description);
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
