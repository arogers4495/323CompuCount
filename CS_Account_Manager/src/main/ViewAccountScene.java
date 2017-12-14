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

 static double total, fee;
 private AccountMember member;
 static Label displayName, displayEmail, displayPhone, displayDescription, poweredBy, transactionLabel;
 static Label labelTotal, labelFee;
 private Button addButton, editButton, logout, home;
 private BorderPane bpane;
 private HBox hbox, hbox1;
 private BorderListener bl;
 private TableColumn<Transaction, String> dateCol, descriptionCol, amountCol, typeCol, WithdrawlDepositCol;
 private ViewAccountListener val;
 private Transaction transaction;

 @SuppressWarnings("rawtypes")
 private final TableView table = new TableView();
 static ObservableList<Transaction> data;
 final HBox hb;

 @SuppressWarnings({ "unchecked", "rawtypes" })
 public ViewAccountScene() {

  data = FXCollections.observableArrayList();
  if (AccountsFile.AccountMembers.size() == 0)
   member = new AccountMember(null, null, null, null, null);
  else
   member = AccountsFile.AccountMembers.get(0);

  hb = new HBox();
  hb.setSpacing(3);

  addButton = new Button("Add Transaction");
  addButton.setFont(new Font("Arial", 15));
  editButton = new Button("Edit");
  editButton.setFont(new Font("Arial", 15));
  
  labelTotal = new Label();
  labelFee = new Label();
  
  transactionLabel = new Label("Transactions");
  dateCol = new TableColumn("Date");
  descriptionCol = new TableColumn("Description");
  amountCol = new TableColumn("Amount");
  typeCol = new TableColumn("Type");
  WithdrawlDepositCol = new TableColumn("Deposit/Withdrawl");

  hb.getChildren().addAll(addButton, labelTotal, labelFee);
  
  table.getColumns().addAll(descriptionCol, amountCol, dateCol, typeCol, WithdrawlDepositCol);

 }

 @SuppressWarnings({ "unchecked" })
 public Scene getViewMember() {

  transactionLabel.setFont(new Font("Arial", 20));

     member = HomeSceneListener.member;
     
     total = member.getTotal();
     fee = member.getFeeAmount();
     
     labelTotal.setText("Total: "  + total);
     labelTotal.setFont(Font.font ("Verdana", 14));
     
     labelFee.setText("WH for Fees: " + fee);
     labelFee.setFont(Font.font ("Verdana", 14));
     
     displayName = new Label("Name:   " + member.getName());// sets the label text to the member's name
     displayEmail = new Label("Email:   " + member.getEmail());
     displayPhone = new Label("Phone#:   " + member.getPhone());
     displayDescription = new Label("Desctiption:   " + member.getDescription());
     
     for(int i = 0; i < member.history.size(); i++) {
         
         transaction = member.history.get(i);
         
         if(data.contains(transaction)) {
             
             continue;
             
         }
         else
         data.add(transaction);
         
     }
     
     transactionLabel.setFont(new Font("Arial", 20));

  transactionLabel.setFont(new Font("Arial", 20));

  table.setEditable(true);

  dateCol.setMinWidth(99);
  dateCol.setCellValueFactory(new PropertyValueFactory<>("Date"));

  descriptionCol.setMinWidth(100);
  descriptionCol.setCellValueFactory(new PropertyValueFactory<>("Description"));

  amountCol.setMinWidth(100);
  amountCol.setCellValueFactory(new PropertyValueFactory<>("Amount"));

  typeCol.setMinWidth(99);
  typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));

  WithdrawlDepositCol.setMinWidth(150);
  WithdrawlDepositCol.setCellValueFactory(new PropertyValueFactory<>("WithdrawlDeposit"));

  table.setItems(data);     
     
     final VBox vbox = new VBox();
     vbox.setSpacing(5);
     vbox.setPadding(new Insets(10, 0, 0, 10));
     vbox.getChildren().addAll(transactionLabel, table, hb);
     
     table.setMaxSize(550, 220);
     
     BorderPane bp = new BorderPane();
     
     GridPane grid = new GridPane();
     grid.setAlignment(Pos.CENTER);
     grid.setHgap(10);
     grid.setVgap(10);
     grid.setPadding(new Insets(25, 25, 25, 25));
     
     //grid.add();
     grid.add(displayName, 0, 1);
     grid.add(displayEmail, 0, 2);
     grid.add(displayPhone, 0 , 3);
     grid.add(displayDescription, 0, 4);
     grid.add(editButton, 0, 5);
     
     bp.setLeft(grid);
     bp.setCenter(vbox);
     
     val = new ViewAccountListener(addButton, editButton, member);
     
     
     addButton.setOnAction(val);
     editButton.setOnAction(val);
     
     Scene ViewScene = new Scene(getFinallayout(bp), 900, 400);
     
     return ViewScene;
     
 }

 public BorderPane getFinallayout(BorderPane bp) {

  logout = new Button("Logout");
  home = new Button("Home");
  poweredBy = new Label("4Guys");

  logout.setFont(new Font("Arial", 15));
  home.setFont(new Font("Arial", 15));

  bpane = new BorderPane();
  hbox = new HBox();
  hbox1 = new HBox();

  hbox.getChildren().addAll(home, logout);
  hbox.setSpacing(5);
  hbox.setPadding(new Insets(5, 0, 0, 10));
  hbox.setAlignment(Pos.TOP_RIGHT);

  hbox1.getChildren().add(poweredBy);
  hbox1.setAlignment(Pos.BOTTOM_RIGHT);

  bpane.setTop(hbox);
  bpane.setBottom(hbox1);

  bl = new BorderListener(logout, home);

  logout.setOnAction(bl);
  home.setOnAction(bl);

  bpane.setCenter(bp);

  return bpane;

 }

}
