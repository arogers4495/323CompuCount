import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AccountFrame extends JFrame {
 public JFrame aFrame;
 public LoginPanel Lpanel;
 public ViewAccountMember accountView;
 public Clayout cl = new Clayout();

 public AccountFrame(String name) {
  aFrame = new JFrame("CS-AccountManager");
  aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  AccountsFile mainFile = new AccountsFile();// this is the main database that will store the account members and their
                                             // information
  accountView = new ViewAccountMember();
  aFrame.getContentPane().add(cl.Show("1"));
  aFrame.pack();
  aFrame.setVisible(true);
  aFrame.getContentPane().add(accountView);
  accountView.setVisible(false);
  Lpanel.login.addActionListener(new login());
  // the method below checks for a username/password match; if they match, the
  // initial view will replace the login panel

 }

 private class login implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent arg0) {

   String checkUser = Lpanel.unameTField.getText();
   String checkPass = Lpanel.pwdTField.getText();
   if (checkUser.equals(Lpanel.usernameActual) && checkPass.equals(Lpanel.passwordActual)) {
    cl.Show("2");
   }
  }

 }

 public static void main(String[] args) {
  AccountFrame acct = new AccountFrame("Test");
 }
}