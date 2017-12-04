import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HomeSceneListener implements EventHandler<ActionEvent>{

    private Button viewAccount, addAccount;
    
    public HomeSceneListener(Button viewAccount, Button addAccount) {
        
        this.viewAccount = viewAccount;
        this.addAccount = addAccount;
        
    }

    @Override
    public void handle(ActionEvent event) {
       
        if(event.getSource() == viewAccount) {
            
            SceneController.ShowViewAccountScene();
            
        }
        
        if(event.getSource() == addAccount) {
            
            SceneController.ShowCreateMember();
            
        }
        
        
    }

}
