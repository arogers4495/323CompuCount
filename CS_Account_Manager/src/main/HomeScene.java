import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;



public class HomeScene {
    
	private Button viewAccount, addAccount;
	private Label name, total;
	
	public HomeScene() {
		
	    
				
	}
	
	public Scene HomeScene(AnchorPane anchor) {
	    
	    BorderPane bp = new BorderPane();
        
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

        anchor.getChildren().add(grid);
        
        Scene homeScene = new Scene(anchor);
	    
	    return homeScene;
	    
	}

}
