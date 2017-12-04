import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BorderListener implements EventHandler<ActionEvent> {

    private Button logout, home;
    
    public BorderListener(Button logout, Button home) {
        
        
        
        this.logout = logout;
        this.home = home;
        
    }

    @Override
    public void handle(ActionEvent event) {
        
        if(event.getSource() == logout) {
            
            SceneController.ShowLogin();
            
        }
        
        if(event.getSource() == home) {
            
            SceneController.showHome();
            
        }
        
    }

}
