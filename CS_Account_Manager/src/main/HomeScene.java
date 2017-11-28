import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class HomeScene {
    
	private Button viewAccount, addAccount;
	private Label name, total;
	private BorderPane bpane;
    private HBox hbox, hbox1;
    private Button logout, home;
    private Label poweredBy;
    private BorderListener bl;
	
	public HomeScene() {
		
	    
	    
	}
	
	public Scene HomeScene() {
        
        viewAccount = new Button("View Account");
        addAccount = new Button("Add Account");
        name = new Label("Josh Anderson");
        total = new Label("0");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(100);
        grid.setVgap(100);
        grid.setPadding(new Insets(25, 25, 25, 25));    
        
        
        grid.add(name, 0, 1);
        grid.add(viewAccount, 2, 1);
        grid.add(total, 1, 1);
        grid.add(addAccount, 1, 2);
        
        logout = new Button("Logout");
        home = new Button("Home");
        poweredBy = new Label("4Guys");
        
        bl = new BorderListener(logout, home);
        
        bpane = new BorderPane();
        hbox = new HBox();
        hbox1 = new HBox();
        
        hbox.getChildren().addAll(home, logout);
        hbox1.getChildren().add(poweredBy);
        
        hbox1.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.setAlignment(Pos.TOP_RIGHT);
        
        bpane.setTop(hbox);
        bpane.setBottom(hbox1);
        
        logout.setOnAction(bl);
        
        home.setOnAction(bl);
        
        bpane.setCenter(grid);
                
        Scene homeScene = new Scene(bpane);
	    
        viewAccount.setOnAction((event) -> {
            if(event.getSource() == viewAccount) {
                
             SceneController.ShowViewAccountScene();
                
            }
        });
        
        addAccount.setOnAction((event) -> {
            if(event.getSource() == addAccount) {
                
                SceneController.ShowCreateMember();
                
            }
        });
        
	    return homeScene;
	    
	}

}
