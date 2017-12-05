import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewAccountScene {
    
 static double total;
 private AccountMember member;
 private Transaction trans;
 private Label displayName, displayEmail, displayPhone, displayDescription, poweredBy, transactionLabel;
static Label labelTotal;
 private Button addButton;
 private BorderPane bpane;
 private HBox hbox, hbox1;
 private BorderListener bl;
 LocalDate localDate;
 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
 TableColumn<Transaction, String> dateCol, descriptionCol, amountCol, typeCol, WithdrawlDepositCol;
 private ViewAccountListener val;
 
 @SuppressWarnings("rawtypes")
 private final TableView table = new TableView();
 static ObservableList<Transaction> data;
 final HBox hb;

 @SuppressWarnings({ "unchecked", "rawtypes" })
public ViewAccountScene() {
 
     dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
     localDate = LocalDate.now();
  
     member = AccountsFile.AccountMembers.get(0);
     
     data.addAll(member.history);
     
     hb = new HBox();
  
  displayName = new Label("Name:   " + member.getFirstName() + member.getLastName());// sets the label text to the member's name
  displayEmail = new Label("Email:   " + member.getEmail());
  displayPhone = new Label("Phone#:   " + member.getPhone());
  displayDescription = new Label("Desctiption:   " + member.getDescription());
  addButton = new Button("Add Transaction");
  total = trans.getAmount();
  labelTotal = new Label("Total: "  + total);
  labelTotal.setFont(Font.font ("Verdana", 14));
  
  transactionLabel = new Label("Transactions");
  dateCol = new TableColumn("Date");
  descriptionCol = new TableColumn("Description");
  amountCol = new TableColumn("Amount");
  typeCol = new TableColumn("Type");
  WithdrawlDepositCol = new TableColumn("Deposit/Withdrawl");

  hb.getChildren().addAll(addButton, labelTotal);
  table.getColumns().addAll(descriptionCol, amountCol, dateCol, typeCol, WithdrawlDepositCol);
  
 } 

 @SuppressWarnings({ "unchecked" })
public Scene ViewMember() {

     
     transactionLabel.setFont(new Font("Arial", 20));

     table.setEditable(true);

     
     dateCol.setMinWidth(99);
     dateCol.setCellValueFactory(
             new PropertyValueFactory<>("Date"));

     
     descriptionCol.setMinWidth(100);
     descriptionCol.setCellValueFactory(
             new PropertyValueFactory<>("Description"));

     
     amountCol.setMinWidth(100);
     amountCol.setCellValueFactory(
             new PropertyValueFactory<>("Amount"));
     
     typeCol.setMinWidth(99);
     typeCol.setCellValueFactory(
             new PropertyValueFactory<>("Type"));
     
     WithdrawlDepositCol.setMinWidth(150);
     WithdrawlDepositCol.setCellValueFactory(
             new PropertyValueFactory<>("WithdrawlDeposit"));
     
     table.setItems(data);
     

     
     hb.setSpacing(3);

     final VBox vbox = new VBox();
     vbox.setSpacing(5);
     vbox.setPadding(new Insets(10, 0, 0, 10));
     vbox.getChildren().addAll(transactionLabel, table, hb);
     
     table.setMaxSize(550, 220);
     
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
     
     bp.setLeft(grid);
     bp.setCenter(vbox);
     
     val = new ViewAccountListener(addButton, member);
     
     addButton.setOnAction(val);
     
     Scene ViewScene = new Scene(getFinallayout(bp), 900, 400);
     
     return ViewScene;
     
 }
 
 public BorderPane getFinallayout(BorderPane bp) {
     
     HBox hbox, hbox1;
     BorderPane bpane;
     Button logout, home;
     Label poweredBy;
     
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
     
     bpane.setCenter(bp);
     
     return bpane;
     
 }
 
}
