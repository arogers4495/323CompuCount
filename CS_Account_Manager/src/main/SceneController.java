import javafx.stage.Stage;

public class SceneController {

    
    private static LoginScene ls;
    private static CreateHolderScene chs;
    private static HomeScene hs;
    private static ViewAccountScene vas;
    private static CreateMemberScene cms;
    private static Stage window;
    
    public SceneController() {
        
        ls = new LoginScene();
        hs = new HomeScene();
        vas = new ViewAccountScene();
        cms = new CreateMemberScene();
        chs = new CreateHolderScene();
        
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

    public static void ShowCreateHolderScene() {
        
        window.setScene(chs.getHolderScene());
        
    }

}
