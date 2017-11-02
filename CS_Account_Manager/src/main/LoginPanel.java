import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

 private JLabel unameLabel, pwdLabel;
 protected JTextField unameTField;
 protected JPasswordField pwdField;
 protected JButton login;
 protected String usernameInput, passwordInput, usernameActual;
 private char[] passwordActual = {'c', 's', 'c', 'i', '3', '2', '3'};
 private Clayout cl;
 
 public LoginPanel(Clayout cl) {

  this.cl = cl;
  unameLabel = new JLabel("Username: ");
  pwdLabel = new JLabel("Password: ");
  login = new JButton("Login");
  unameTField = new JTextField("", 10);
  pwdField = new JPasswordField("", 10);
  
  // username and password for testing purposes
  usernameActual = "csadmin";
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
  pwdPanel.add(pwdField);
  panelLayout.add(pwdPanel);

  lButtonPanel.add(login);
  panelLayout.add(lButtonPanel);

  login.addActionListener(new ButtonListener());

 }

 private class ButtonListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent event) {
  
      String uname = unameTField.getText();
      char[] pwd = pwdField.getPassword();
      
      if(event.getSource() == login) {
          if(uname.equals(usernameActual) && Arrays.equals(pwd, passwordActual)) {
              
              cl.ChangePanel("Home");
              System.out.println("Access Granted!");
          }
          else
              JOptionPane.showMessageDialog(null, "Username or Password is Incorrect!");
          
          if(!uname.equals(usernameActual)) {
              
              unameTField.setBackground(Color.red);
          }
          
          if(!Arrays.equals(pwd, passwordActual)) {
              
              pwdField.setBackground(Color.red);
              
          }
      }
  
 }
 }
}

