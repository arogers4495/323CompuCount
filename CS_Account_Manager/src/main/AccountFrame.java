import javax.swing.JFrame;

public class AccountFrame extends JFrame {

 private static JFrame aFrame;
 private static LoginPanel Lpanel;
 private static ViewAccountMember accountView;
 private static HomePanel homePanel;
 private static CreateMemberPanel cmPanel;

 private static Clayout cl = new Clayout();

 public static void main(String[] args) {

  accountView = new ViewAccountMember(cl);
  Lpanel = new LoginPanel(cl);
  homePanel = new HomePanel(cl);
  cmPanel = new CreateMemberPanel(cl);

  cl.AddPanel(Lpanel, "Login");
  cl.AddPanel(homePanel, "Home");
  cl.AddPanel(accountView, "Account Member");
  cl.AddPanel(cmPanel, "Create Member");

  aFrame = new JFrame("CS-AccountManager");

  aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  aFrame.getContentPane().add(cl.Show());
  aFrame.pack();
  aFrame.setVisible(true);

 }

}
