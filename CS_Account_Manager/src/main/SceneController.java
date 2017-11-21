import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

    private LoginScene ls;
    private HomeScene hs;
    private ViewAccountScene vas;
    private CreateMemberScene cms;
    private Anchor

    
    public SceneController(Stage primaryStage) {
        
        ls = new LoginScene();
        hs = new HomeScene();
        vas = new ViewAccountScene();
        cms = new CreateMemberScene();
        
    }

    public Scene Show() {
        
        return hs.HomeScene();
    }

    public Scene ShowLogin() {
        
        return ls.LoginScene();
    }

}
