import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

public class ViewAccountScene {
 private AccountMember member;
 private Transaction trans;
 private Label displayName, displayEmail, displayPhone, displayDescription, poweredBy;
 private Button homeButton, deleteAccount, logout, home, addButton;
 private BorderPane bpane;
 private HBox hbox, hbox1;
 private BorderListener bl;
 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
 LocalDate localDate = LocalDate.now();
 
 
 @SuppressWarnings("rawtypes")
 private final TableView table = new TableView();
 private final ObservableList<Transaction> data;
 final HBox hb = new HBox();

 public ViewAccountScene() {
 
     
     data = FXCollections.observableArrayList(
             trans = new Transaction(localDate, "Student", "1000")
         );
  
     member = new AccountMember("Josh", "Anderson", "janderson152481@gmail.com", "4066261873", "Student");
     
  
  displayName = new Label("Name:   " + member.getFirstName() + member.getLastName());// sets the label text to the member's name
  displayEmail = new Label("Email:   " + member.getEmail());
  displayPhone = new Label("Phone#:   " + member.getPhone());
  displayDescription = new Label("Desctiption:   " + member.getDescription());
  homeButton = new Button("Home");// initializes the Log Out button
  deleteAccount = new Button("Delete Account");// initializes the Delete Account butt
  poweredBy = new Label("Powered By 4Guys");
  logout = new Button("Logout");
  addButton = new Button("Add Transactoin");
  
 } 

 @SuppressWarnings({ "unchecked", "rawtypes" })
public Scene ViewMemberScene() {
     
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

     hb.getChildren().add(addButton);
     hb.setSpacing(3);

     final VBox vbox = new VBox();
     vbox.setSpacing(5);
     vbox.setPadding(new Insets(10, 0, 0, 10));
     vbox.getChildren().addAll(label, table, addButton);
     
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
     grid.add(deleteAccount, 0, 6);
     
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
     
     

     
     deleteAccount.setOnAction((event) -> {
         if(event.getSource() == deleteAccount) {
             
             Stage popupwindow=new Stage();
             
             popupwindow.initModality(Modality.APPLICATION_MODAL);
             popupwindow.setTitle("Delete Account!");
                   
                   
             Label label1= new Label("Are You Sure!");
                   
                  
             Button button1= new Button("Delete Account!");
                  
                  
             button1.setOnAction(e -> popupwindow.close());
                  
                  

             VBox layout= new VBox(10);
                  
                   
             layout.getChildren().addAll(label1, button1);
                   
             layout.setAlignment(Pos.CENTER);
                   
             Scene scene1= new Scene(layout, 300, 250);
                   
             popupwindow.setScene(scene1);
                   
             popupwindow.showAndWait();;
             
         }
     });
     
     addButton.setOnAction((event) -> {
         if(event.getSource() == addButton) {
             
             Stage popupwindow=new Stage();
             
             popupwindow.initModality(Modality.APPLICATION_MODAL);
             popupwindow.setTitle("Add Transaction");                   
                  
             Button button1= new Button("Enter");
             TextField amount = new TextField();
             TextField description = new TextField();    
             button1.setOnAction(e -> {                 
                 
                 data.add(new Transaction(
                         
                         localDate,
                         description.getText(),
                         amount.getText()
                         
                         
                 ));
             popupwindow.close();
             
             });
                  
                  

             VBox layout= new VBox(10);
                  
                   
             layout.getChildren().addAll(button1);
                   
             layout.setAlignment(Pos.CENTER);
                   
             Scene scene1= new Scene(layout, 300, 250);
                   
             popupwindow.setScene(scene1);
                   
             popupwindow.showAndWait();
             
         }
     });

     
     Scene ViewMemberScene = new Scene(bpane, 800, 400);
     
     return ViewMemberScene;
     
 }
 
}
