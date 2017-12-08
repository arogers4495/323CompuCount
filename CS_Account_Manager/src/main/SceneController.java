import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SceneController {

    
    private static LoginScene ls;
    private static HomeScene hs;
    private static ViewAccountScene vas;
    private static CreateMemberScene cms;
    private static Stage window;
    
    public SceneController() {
        
        ls = new LoginScene();
        hs = new HomeScene();
        vas = new ViewAccountScene();
        cms = new CreateMemberScene();
        
        
        
        
    }

    public static void ShowHome() {
        
        window.setScene(hs.getHomeScene());
    }

    public static void ShowLogin() {
        
       window.setScene(ls.getLoginScene());
    }
    
    public static void ShowViewAccountScene() {
        
        window.setScene(vas.getViewMember());
     }
    
    public static void ShowCreateMember() {
        
        window.setScene(cms.getCreateScene());
     }
    
    public static void setStage(Stage primaryStage) {
        
        window = primaryStage;
        
    }

}
