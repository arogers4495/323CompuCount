import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class HomeScene {
    
	private Button viewAccount, addAccount;
	private ArrayList<Label> names;
	private ArrayList<Label> totals;
	private Label name, total;
	private BorderPane bpane;
    private HBox hbox, hbox1, hbox2;
    private VBox vbox;
    private Button logout, home;
    private Label poweredBy;
    private BorderListener bl;
	private HomeSceneListener hsl;
	private AccountMember member;
    private ArrayList<AccountMember> membersList;
    TableColumn<AccountMember, String> nameCol ,amountCol;
    @SuppressWarnings("rawtypes")
    private final TableView table = new TableView();
    static ObservableList<AccountMember> data;
    
	@SuppressWarnings("unchecked")
    public HomeScene() {
		
	    membersList = AccountsFile.getMembersList();	
	   

	    nameCol = new TableColumn<AccountMember, String>("Name");
	    amountCol = new TableColumn<AccountMember, String>("Amount");
	    
	    
	    data = FXCollections.observableArrayList(
	             membersList
	         );
	    
	    table.getColumns().addAll(nameCol, amountCol);
	    
	    viewAccount = new Button("View Account");
	    addAccount = new Button("Add Account");
	    
	}
	
	@SuppressWarnings("unchecked")
    public Scene HomeScene() {        
        
	    table.setEditable(true);
	    
	    amountCol.setMinWidth(100);
	     amountCol.setCellValueFactory(
	             new PropertyValueFactory<>("Amount"));
	     
	     nameCol.setMinWidth(100);
	     nameCol.setCellValueFactory(
	             new PropertyValueFactory<>("Name"));
	     
	     table.setItems(data);
	     
	     final VBox vbox = new VBox();
	     vbox.setSpacing(5);
	     vbox.setPadding(new Insets(10, 0, 0, 10));
	     vbox.getChildren().addAll(table);
	    
        hsl = new HomeSceneListener(viewAccount, addAccount);
        
        viewAccount.setOnAction(hsl);
        addAccount.setOnAction(hsl);
        
        Scene HomeScene = new Scene(getFinallayout(vbox), 500, 500);
        
	    return HomeScene;
	    
	}

	public BorderPane getFinallayout(VBox vbox2) {
	     
	     logout = new Button("Logout");
	     home = new Button("Home");
	     poweredBy = new Label("4Guys");
	     
	     logout = new Button("Logout");
	     home = new Button("Home");
	     poweredBy = new Label("4Guys");
	     
	     bpane = new BorderPane();
	     hbox = new HBox();
	     hbox1 = new HBox();
	     
	     hbox.getChildren().addAll(home, logout);
	     hbox1.getChildren().add(poweredBy);
	     
	     hbox1.setAlignment(Pos.BOTTOM_RIGHT);
	     hbox.setAlignment(Pos.TOP_RIGHT);
	     
	     bpane.setTop(hbox);
	     bpane.setBottom(hbox1);
	     
	     bl = new BorderListener(logout, home);
	     
	     logout.setOnAction(bl);
	     home.setOnAction(bl);
	     
	     bpane.setCenter(vbox2);
	     
	     return bpane;
	     
	 }
	
}
