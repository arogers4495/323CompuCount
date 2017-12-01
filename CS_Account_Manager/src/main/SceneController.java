import java.io.IOException;

import javafx.stage.Stage;

public class SceneController {

    private static LoginScene ls;
    private static HomeScene hs;
    private static ViewAccountScene vas;
    private static CreateMemberScene cms;
    private static Stage window;
    
    public SceneController() throws IOException {
        
        ls = new LoginScene();
        hs = new HomeScene();
        vas = new ViewAccountScene();
        cms = new CreateMemberScene();
        
    }

    public static void ShowHome() {
        
        window.setScene(hs.HomeScene());
    }

    public static void ShowLogin() {
        
       window.setScene(ls.LoginScene());
    }
    
    public static void ShowViewAccountScene() {
        
        window.setScene(vas.ViewMemberScene());
     }
    
    public static void ShowCreateMember() {
        
        window.setScene(cms.CreateMemberScene());
     }
    
    public static void setStage(Stage primaryStage) {
        
        window = primaryStage;
        
    }

}
