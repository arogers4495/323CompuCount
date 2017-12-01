import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CreateMemberListener implements EventHandler<ActionEvent>{

    private Button submit;
    
    public CreateMemberListener(Button submit) {
        
        this.submit = submit;
        
    }

    @Override
    public void handle(ActionEvent event) {
        
        if(event.getSource() == submit) {
            
            
            
        }
        
    }

}
