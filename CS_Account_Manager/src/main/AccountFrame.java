import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

public class AccountFrame extends Application {
 protected AccountsFile mainFile;

 public static void main(String[] args) throws IOException {
  AccountsFile mainFile = new AccountsFile();
  launch(args);

 }

 @Override
 public void start(Stage window) throws Exception {

  LoginPanel lp = new LoginPanel();

  window.setTitle("CS AccountManager");
  window.setScene(lp.LoginScene(window));
  window.show();

 }

}
