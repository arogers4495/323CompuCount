import java.io.IOException;

import javax.swing.JFrame;

public class Main {

 public static void main(String[] args) throws IOException {

  AccountFrame aFrame = new AccountFrame("CS-AccountManager");
  aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  CreateMemberPanel Lpanel = new CreateMemberPanel();
  ViewAccountMember accountView = new ViewAccountMember();
  aFrame.getContentPane().add(Lpanel);
  aFrame.pack();
  aFrame.setVisible(true);
 }
}
