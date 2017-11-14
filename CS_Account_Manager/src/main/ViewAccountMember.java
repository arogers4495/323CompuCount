import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewAccountMember {
 private AccountMember member;
 private Label displayName, displayEmail, displayPhone, displayDescription, poweredBy;
 private Button homeButton, deleteAccount, logout;
 private Image profile;
 private final TableView table = new TableView();
 private final ObservableList<Object> data =
         FXCollections.observableArrayList(
                 new Transaction("11/01/2017", "Student Payment", "350.00"),
                 new Transaction("11/11/2017", "Donation", "450.00"),
                 new Transaction("10/12/2017", "Donation", "50.00"),
                 new Transaction("09/11/2017", "Student Payment", "150.00"),
                 new Transaction("11/10/2017", "Student Payment", "25.00"));
 private LoginPanel lp = new LoginPanel();
 private HomePanel hp;
 final HBox hb = new HBox();
 
 public ViewAccountMember() {
 

  member = new AccountMember("Jake", "Anderson", "janderson152481@gmail.com", "406-626-1873", "Student");
  
  displayName = new Label("Name:   " + member.getFirstName() + member.getLastName());// sets the label text to the member's name
  displayEmail = new Label("Email:   " + member.getEmail());
  displayPhone = new Label("Phone#:   " + member.getPhone());
  displayDescription = new Label("Desctiption:   " + member.getDescription());
  homeButton = new Button("Home");// initializes the Log Out button
  deleteAccount = new Button("Delete Account");// initializes the Delete Account butt
  poweredBy = new Label("Powered By 4Guys");
  logout = new Button("Logout");

 } 

 public Scene ViewMemberScene(Stage window) {
     
     final Label label = new Label("Transactions");
     label.setFont(new Font("Arial", 20));

     table.setEditable(true);

     TableColumn firstNameCol = new TableColumn("Date");
     firstNameCol.setMinWidth(100);
     firstNameCol.setCellValueFactory(
             new PropertyValueFactory<>("Date"));

     TableColumn lastNameCol = new TableColumn("Description");
     lastNameCol.setMinWidth(100);
     lastNameCol.setCellValueFactory(
             new PropertyValueFactory<>("Description"));

     TableColumn emailCol = new TableColumn("Amount");
     emailCol.setMinWidth(200);
     emailCol.setCellValueFactory(
             new PropertyValueFactory<>("Amount"));

     table.setItems(data);
     table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

     final TextField addDate = new TextField();
     addDate.setPromptText("Date");
     addDate.setMaxWidth(firstNameCol.getPrefWidth());
     
     final TextField addDescription = new TextField();
     addDescription.setMaxWidth(lastNameCol.getPrefWidth());
     addDescription.setPromptText("Description");
     
     final TextField addAmount = new TextField();
     addAmount.setMaxWidth(emailCol.getPrefWidth());
     addAmount.setPromptText("Amount");

     final Button addButton = new Button("Add");
     addButton.setOnAction((ActionEvent e) -> {
         data.add(new Transaction(
                 addDate.getText(),
                 addDescription.getText(),
                 addAmount.getText()));
         addDate.clear();
         addDescription.clear();
         addAmount.clear();
     });

     hb.getChildren().addAll(addDate, addDescription, addAmount, addButton);
     hb.setSpacing(3);

     final VBox vbox = new VBox();
     vbox.setSpacing(5);
     vbox.setPadding(new Insets(10, 0, 0, 10));
     vbox.getChildren().addAll(label, table, hb);
     
     table.setMaxSize(410, 200);
     
     BorderPane bp = new BorderPane();
     
     GridPane grid = new GridPane();
     grid.setAlignment(Pos.TOP_LEFT);
     grid.setHgap(10);
     grid.setVgap(10);
     grid.setPadding(new Insets(25, 25, 25, 25));
     
     //grid.add();
     grid.add(displayName, 0, 1);
     grid.add(displayEmail, 0, 2);
     grid.add(displayPhone, 0 , 3);
     grid.add(displayDescription, 0, 4);
     grid.add(homeButton, 0, 0);
     grid.add(deleteAccount, 0, 6);
     
     bp.setLeft(grid);
     bp.setCenter(vbox);
     bp.setBottom(poweredBy);
     bp.setTop(logout);
     
     logout.setOnAction((event) -> {
         if(event.getSource() == logout) {
             
             window.setScene(lp.LoginScene(window));
             
         }
     });
     
     homeButton.setOnAction((event) -> {
         if(event.getSource() == homeButton) {
             
             window.setScene(hp.HomeScene(window));
             
         }
     });
     
     deleteAccount.setOnAction((event) -> {
         if(event.getSource() == homeButton) {
             
             ;
             
         }
     });

     
     Scene ViewMemberScene = new Scene(bp, 800, 500);
     
     return ViewMemberScene;
     
 }
 
}
