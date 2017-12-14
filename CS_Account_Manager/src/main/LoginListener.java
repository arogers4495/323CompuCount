import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class LoginListener implements EventHandler<ActionEvent>{

    private Button login;
    
    public LoginListener(Button login) {
        
        this.login = login;
        
    }

    @Override
    public void handle(ActionEvent event) {
        
        if(event.getSource() == login) {
            
            String uname = LoginScene.unameTField.getText();
            String pwd = LoginScene.pwdField.getText();
            
            if(uname.equals(AccountHolder.getUsername()) && pwd.equals(AccountHolder.getPassword())) {
                
                SceneController.ShowHome();
                
            }
            else {
                
                LoginScene.lPrompt.setText("*All Fields Required!");
                LoginScene.lPrompt.setFont(Font.font ("Verdana", 12));
                LoginScene.lPrompt.setTextFill(Paint.valueOf("RED"));
                LoginScene.unameTField.clear();
                LoginScene.pwdField.clear();
                
            }
            
        }
        
    }

}
