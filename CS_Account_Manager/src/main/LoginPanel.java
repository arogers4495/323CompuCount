import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

 private JLabel unameLabel, pwdLabel;
 protected JTextField unameTField, pwdTField;
 protected JButton login;
 protected String usernameInput, passwordInput, usernameActual, passwordActual;
 private Clayout cl;
 
 public LoginPanel(Clayout cl) {

  this.cl = cl;
  unameLabel = new JLabel("Username: ");
  pwdLabel = new JLabel("Password: ");
  login = new JButton("Login");
  unameTField = new JTextField("", 10);
  pwdTField = new JTextField("", 10);
  
  // username and password for testing purposes
  usernameActual = "csadmin";
  passwordActual = "csci323";
  setPreferredSize(new Dimension(300, 300));
  setBackground(Color.WHITE);

  this.setLayout(new BorderLayout());
  GridLayout grid = new GridLayout(4, 1);
  JPanel panelLayout = new JPanel(grid);
  JPanel uNamePanel = new JPanel();
  JPanel pwdPanel = new JPanel();
  JPanel lButtonPanel = new JPanel();

  this.add(panelLayout, BorderLayout.CENTER);
  uNamePanel.add(unameLabel);
  uNamePanel.add(unameTField);
  panelLayout.add(uNamePanel);

  pwdPanel.add(pwdLabel);
  pwdPanel.add(pwdTField);
  panelLayout.add(pwdPanel);

  lButtonPanel.add(login);
  panelLayout.add(lButtonPanel);

  login.addActionListener(new textListen());

 }

 private class textListen implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent arg0) {
  
      String uname = unameTField.getText();
      String pwd = pwdTField.getText();

      if(uname.equals(usernameActual) && pwd.equals(passwordActual)) {
      
          cl.changePanel("Home");
          System.out.println("Access Granted!");
                    
      }
  
 }
 }
}

