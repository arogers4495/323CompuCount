import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AccountFrame extends JFrame {
 public JFrame aFrame;
 public LoginPanel Lpanel;
 public ViewAccountMember accountView;

 public AccountFrame(String name) {
  aFrame = new JFrame("CS-AccountManager");
  aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Lpanel = new LoginPanel();
  accountView = new ViewAccountMember();
  aFrame.getContentPane().add(Lpanel);
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
    Lpanel.setVisible(false);
    accountView.setVisible(true);
   }
  }

 }

 public static void main(String[] args) {
  AccountFrame acct = new AccountFrame("Test");
 }
}