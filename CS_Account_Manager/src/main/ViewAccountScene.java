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
    
    int total;
 private AccountMember member;
 private Transaction trans;
 private Label displayName, displayEmail, displayPhone, displayDescription, poweredBy, transactionLabel, labelTotal;
 private Button logout, home, addButton;
 private BorderPane bpane;
 private HBox hbox, hbox1;
 private BorderListener bl;
 LocalDate localDate;
 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
 TableColumn<Transaction, String> dateCol, descriptionCol, amountCol, typeCol, WithdrawlDepositCol;
 
 @SuppressWarnings("rawtypes")
 private final TableView table = new TableView();
 private final ObservableList<Transaction> data;
 final HBox hb = new HBox();

 @SuppressWarnings({ "unchecked", "rawtypes" })
public ViewAccountScene() {
 
     dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
     localDate = LocalDate.now();
     
     data = FXCollections.observableArrayList(
             trans = new Transaction(localDate, "Student", "1000", "Card", "Deposit")
         );
  
     member = new AccountMember("Josh", "Anderson", "janderson152481@gmail.com", "4066261873", "Student");
     
  
  displayName = new Label("Name:   " + member.getFirstName() + member.getLastName());// sets the label text to the member's name
  displayEmail = new Label("Email:   " + member.getEmail());
  displayPhone = new Label("Phone#:   " + member.getPhone());
  displayDescription = new Label("Desctiption:   " + member.getDescription());
  poweredBy = new Label("Powered By 4Guys");
  logout = new Button("Logout");
  addButton = new Button("Add Transaction");
  total = Integer.parseInt(trans.getAmount());
  labelTotal = new Label("Total: "  + total);
  labelTotal.setFont(Font.font ("Verdana", 14));
  
  transactionLabel = new Label("Transactions");
  dateCol = new TableColumn("Date");
  descriptionCol = new TableColumn("Description");
  amountCol = new TableColumn("Amount");
  typeCol = new TableColumn("Type");
  WithdrawlDepositCol = new TableColumn("Deposit/Withdrawl");

  table.getColumns().addAll(descriptionCol, amountCol, dateCol, typeCol, WithdrawlDepositCol);
  
 } 

 @SuppressWarnings({ "unchecked" })
public Scene ViewMemberScene() {

     
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
     

     hb.getChildren().addAll(addButton, labelTotal);
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
     
     bpane.setCenter(bp);
     
     
     addButton.setOnAction((event) -> {
         if(event.getSource() == addButton) {
             
             Stage popupwindow=new Stage();
             
             popupwindow.initModality(Modality.APPLICATION_MODAL);
             popupwindow.setTitle("Add Transaction");                   
                  
             Button button1 = new Button("Enter");
             
             Label lPrompt = new Label();
             Label lAmount = new Label("Amount");
             Label labelType = new Label("Type");
             Label labelInorOut = new Label("Withdrawl/Deposit");
             Label lDescription = new Label("Description");
             Label code = new Label("Code");
             
             TextField amount = new TextField();
             TextField description = new TextField(); 
             
             ComboBox<String> codeBox = new ComboBox<String>();
             codeBox.getItems().addAll("MAF654845","KTO987856","HJT12478555");
             codeBox.setEditable(true);
             
             ComboBox<String> typeBox = new ComboBox<String>();
             typeBox.getItems().addAll("Card","Cash","Check");
             typeBox.setEditable(true);
             
             ComboBox<String> dwBox = new ComboBox<String>();
             dwBox.getItems().addAll("Withdrawl","Deposit");
             dwBox.setEditable(true);
             
             
             button1.setOnAction(e -> {                 
                 
                 if(amount.getText().trim().isEmpty() || description.getText().trim().isEmpty()) {
                     
                     lPrompt.setText("*All Fields Required!");
                     lPrompt.setFont(Font.font ("Verdana", 12));
                     lPrompt.setTextFill(Paint.valueOf("RED"));
                     amount.clear();
                     description.clear();
                         
                 }
                 else {
                     
                     data.add(new Transaction(
                         
                         localDate,
                         codeBox.getSelectionModel().getSelectedItem().toString() + " " + description.getText(),
                         amount.getText(),
                         typeBox.getSelectionModel().getSelectedItem().toString(),
                         dwBox.getSelectionModel().getSelectedItem().toString()
                         
                             ));
                     
                     
                     
                     if(dwBox.getSelectionModel().getSelectedItem() == "Deposit"){
                         
                         total = total + Integer.parseInt(amount.getText());
                         
                         labelTotal.setText("Total: " + total);
                         
                     }
                     else{
                         
                         total = total - Integer.parseInt(amount.getText());
                         
                         labelTotal.setText("Total: " + total);
                         
                     }
                     
                     
                     
                     
                     popupwindow.close();
                     
                 }
                 
             
             
             });
                  
                  

             GridPane grid1 = new GridPane();
             grid1.setAlignment(Pos.CENTER);
             grid1.setHgap(10);
             grid1.setVgap(10);
             grid1.setPadding(new Insets(25, 25, 25, 25));
             
             grid1.add(lPrompt, 1, 0);
             grid1.add(lAmount, 0, 1);
             grid1.add(amount, 1, 1);
             grid1.add(lDescription, 0, 2);
             grid1.add(description, 1, 2);
             grid1.add(code, 0, 3);
             grid1.add(codeBox, 1, 3);
             grid1.add(labelType, 0, 4);
             grid1.add(typeBox , 1, 4);
             grid1.add(labelInorOut , 0, 5);
             grid1.add(dwBox , 1, 5);
             
             HBox hbBtn = new HBox(10);
             hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
             hbBtn.getChildren().add(button1);
             grid1.add(hbBtn, 1, 6);
             
                   
             Scene scene1= new Scene(grid1, 400, 250);
                   
             popupwindow.setScene(scene1);
                   
             popupwindow.showAndWait();
             
         }
     });

     
     Scene ViewMemberScene = new Scene(bpane, 900, 400);
     
     return ViewMemberScene;
     
 }
 
}
