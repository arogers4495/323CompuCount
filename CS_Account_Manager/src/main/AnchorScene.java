import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class AnchorScene extends Parent{

    private AnchorPane apane;
    private HBox hbox, hbox1;
    private Button logout, home;
    private Label poweredBy;
    
    public AnchorScene() {
        
        apane = new AnchorPane();
        hbox = new HBox();
        hbox1 = new HBox();
        
        logout = new Button("Logout");
        home = new Button("Home");
        poweredBy = new Label("4Guys");
        
        hbox.getChildren().addAll(logout, home);
        hbox1.getChildren().add(poweredBy);
        
        hbox1.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.setAlignment(Pos.TOP_RIGHT);
        
        apane.getChildren().addAll(hbox,hbox1);
        
    }
    
    public AnchorPane aPane() {
        
        return apane;
        
    }

}
