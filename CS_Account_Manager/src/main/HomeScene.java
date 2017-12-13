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
 private HomeSceneListener hsl;

 public HomeScene() {

  viewAccount = new Button("View Account");
  addAccount = new Button("Add Account");
  name = new Label("");
  total = new Label("0");

 }

 public Scene HomeScene() {

  GridPane grid = new GridPane();
  grid.setAlignment(Pos.CENTER);
  grid.setHgap(100);
  grid.setVgap(100);
  grid.setPadding(new Insets(25, 25, 25, 25));

  grid.add(name, 0, 1);
  grid.add(viewAccount, 2, 1);
  grid.add(total, 1, 1);
  grid.add(addAccount, 1, 2);

  hsl = new HomeSceneListener(viewAccount, addAccount);

  viewAccount.setOnAction(hsl);
  addAccount.setOnAction(hsl);

  Scene HomeScene = new Scene(getFinallayout(grid), 500, 500);

  return HomeScene;

 }

 public BorderPane getFinallayout(GridPane grid) {

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

  bpane.setCenter(grid);

  return bpane;

 }

}
