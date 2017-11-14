import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class HomePanel {
    
	private Button logout, viewAccount, addAccount;
	private Label name, total, poweredBy;
	private ViewAccountMember vam;
	private LoginPanel lp = new LoginPanel();
	private CreateMemberPanel cmp = new CreateMemberPanel();
	public HomePanel() {
		
	    vam = new ViewAccountMember();
				
	}
	
	public Scene HomeScene(Stage window) {
        
	    BorderPane bp = new BorderPane();
	    
        logout = new Button("Logout");
        viewAccount = new Button("View Account");
        addAccount = new Button("Add Account");
        poweredBy = new Label("Powered By 4Guys");
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
        
        viewAccount.setOnAction((event) -> {
            if(event.getSource() == viewAccount) {
                
                window.setScene(vam.ViewMemberScene(window));
                    
                }
               
        });
        
        addAccount.setOnAction((event) -> {
            if(event.getSource() == addAccount) {
                
                window.setScene(cmp.CreateMemberScene(window));
                    
                }
               
        });
        
        logout.setOnAction((event) -> {
            if(event.getSource() == logout) {
                
                window.setScene(lp.LoginScene(window));
                
            }
        });
        
        bp.setCenter(grid);
        bp.setBottom(poweredBy);
        bp.setTop(logout);
        
        Scene homeScene = new Scene(bp, 700, 500);
        
        return homeScene;
	    
	}

}
