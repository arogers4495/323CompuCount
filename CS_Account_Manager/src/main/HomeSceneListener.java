import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class HomeSceneListener implements EventHandler<ActionEvent>{

    private Button viewAccount, addAccount, delAccount;
    private TableView<AccountMember> table;
    static AccountMember member;
    
    public HomeSceneListener(Button viewAccount, Button addAccount, Button delAccount, TableView<AccountMember> table) {
        
        this.viewAccount = viewAccount;
        this.addAccount = addAccount;
        this.delAccount = delAccount;
        this.table = table;
    }

    @Override
    public void handle(ActionEvent event) {
       
        if(event.getSource() == viewAccount) {
            
           member = table.getSelectionModel().getSelectedItem();
            
            SceneController.ShowViewAccountScene();
            
        }
        
        if(event.getSource() == addAccount) {
            
            SceneController.ShowCreateMember();
            
        }
        
        
    }

}
