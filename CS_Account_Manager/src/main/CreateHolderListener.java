import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CreateHolderListener implements EventHandler<ActionEvent>{

    private Button submit;
    private String firstName, lastName, username, password;
    
    public CreateHolderListener(Button submit) {
        
        this.submit = submit;
        
    }
    
    public void handle(ActionEvent event){
        
        if(event.getSource() == submit) {
            
            firstName = CreateHolderScene.firstNameTField.getText().trim();
            lastName = CreateHolderScene.lastNameTField.getText().trim();
            username = CreateHolderScene.usernameTField.getText().trim();
            password = CreateHolderScene.passwordTField.getText().trim();
                        
            AccountHolder holder = new AccountHolder(firstName, lastName, username, password);
            
            try {
                AccountsFile.addAccountHolder(holder);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            SceneController.ShowLogin();
            
        }
        
    }

}
