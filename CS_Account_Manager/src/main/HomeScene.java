import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HomeScene {

 private Button viewAccount, addAccount, delAccount, viewButton;
 private Label memberLabel, adminLabel;
 private BorderPane bpane, bp;
 private HBox hbox, hbox1, hbox2, viewTrans;
 private VBox vbox, vbox1;
 private Button logout, home;
 private Label poweredBy;
 private BorderListener bl;
 private HomeSceneListener hsl;
 private AccountMember member;
 private AccountHolder holder;
 private ArrayList<AccountMember> membersList;
 TableColumn<AccountMember, String> nameCol, totalCol;
 private final TableView<AccountMember> table = new TableView<AccountMember>();
 static ObservableList<AccountMember> data;

 @SuppressWarnings("unchecked")
 public HomeScene() {

  membersList = AccountsFile.getMembersList();

  holder = AccountsFile.holder;

  memberLabel = new Label("Members");

  nameCol = new TableColumn<AccountMember, String>("Name");
  totalCol = new TableColumn<AccountMember, String>("Amount");

  data = FXCollections.observableArrayList();

  table.getColumns().addAll(nameCol, totalCol);

  viewAccount = new Button("View Account");
  addAccount = new Button("Add Account");
  delAccount = new Button("Delete Account");
  viewButton = new Button("View Report");

 }

 public Scene getHomeScene() {

  adminLabel = new Label(holder.getLname() + ", " + holder.getFname());

  for (int i = 0; i < membersList.size(); i++) {

   member = membersList.get(i);

   if (data.contains(member)) {

    continue;

   } else
    data.add(member);

  }

  table.refresh();

  table.setEditable(true);

  table.setMaxSize(800, 220);

  viewAccount.setPrefSize(200, 20);
  addAccount.setPrefSize(200, 20);
  delAccount.setPrefSize(200, 20);

  adminLabel.setFont(new Font("Arial", 50));
  memberLabel.setFont(new Font("Arial", 20));
  viewAccount.setFont(new Font("Arial", 15));
  addAccount.setFont(new Font("Arial", 15));
  delAccount.setFont(new Font("Arial", 15));
  viewButton.setFont(new Font("Arial", 15));

  nameCol.setMinWidth(400);
  nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));

  totalCol.setMinWidth(385);
  totalCol.setCellValueFactory(new PropertyValueFactory<>("Total"));

  table.setItems(data);

  vbox = new VBox();
  vbox.setSpacing(5);
  vbox.setPadding(new Insets(10, 0, 0, 10));
  vbox.getChildren().addAll(memberLabel, table, viewButton);
  vbox.setAlignment(Pos.CENTER);

  vbox1 = new VBox();
  vbox1.setSpacing(20);
  vbox1.setPadding(new Insets(40, 0, 25, 50));
  vbox1.getChildren().addAll(viewAccount, addAccount, delAccount);
  vbox1.setAlignment(Pos.CENTER);

  hbox2 = new HBox();
  hbox2.setSpacing(20);
  hbox2.setPadding(new Insets(40, 0, 25, 50));
  hbox2.getChildren().add(adminLabel);

  bp = new BorderPane();
  bp.setLeft(vbox1);
  bp.setCenter(vbox);
  bp.setTop(hbox2);

  hsl = new HomeSceneListener(viewAccount, addAccount, delAccount, table, viewButton);

  viewAccount.setOnAction(hsl);
  addAccount.setOnAction(hsl);
  delAccount.setOnAction(hsl);
  viewButton.setOnAction(hsl);

  Scene HomeScene = new Scene(getFinallayout(bp), 1200, 500);

  return HomeScene;

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
