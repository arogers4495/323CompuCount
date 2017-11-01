import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.util.ArrayList;

public class CreateMemberPanel extends JPanel {

 private JLabel firstNameLabel, lastNameLabel;
 private JTextField firstNameTField, lastNameTField;
 private JButton submit, home;
 private String firstName, lastName;

 ArrayList<AccountMember> myList = new ArrayList<AccountMember>();

 public void createAccount(AccountMember NewMember) {

 }

 public CreateMemberPanel() {

  firstNameLabel = new JLabel("First Name:");
  lastNameLabel = new JLabel("Last Name:");
  firstNameTField = new JTextField(10);
  lastNameTField = new JTextField(10);

  submit = new JButton("Submit");
  home = new JButton("Home");

  ButtonListener listener = new ButtonListener();
  submit.addActionListener(listener);
  home.addActionListener(listener);

  setPreferredSize(new Dimension(500, 500));
  setBackground(Color.WHITE);

  this.setLayout(new BorderLayout());
  GridLayout grid = new GridLayout(4, 1);
  JPanel panelLayout = new JPanel(grid);
  JPanel firstNamePanel = new JPanel();
  JPanel lastNamePanel = new JPanel();
  JPanel sButtonPanel = new JPanel();
  JPanel hButtonPanel = new JPanel();

  this.add(panelLayout, BorderLayout.CENTER);
  firstNamePanel.add(firstNameLabel);
  firstNamePanel.add(firstNameTField);
  panelLayout.add(firstNamePanel);

  lastNamePanel.add(lastNameLabel);
  lastNamePanel.add(lastNameTField);
  panelLayout.add(lastNamePanel);

  sButtonPanel.add(submit);
  panelLayout.add(sButtonPanel);

  hButtonPanel.add(home);
  panelLayout.add(hButtonPanel);

 }

 private class ButtonListener implements ActionListener {
  public void actionPerformed(ActionEvent event) {
   String firstName, lastName;

   firstName = firstNameTField.getText();
   lastName = lastNameTField.getText();

   if (event.getSource() == home)
    System.out.println("home");
   else if (event.getSource() == submit) {
    if (firstName.equals("") || lastName.equals("")) {
     JOptionPane.showMessageDialog(null, "Please enter your First and last name.");
    }
    System.out.println("submit");
    AccountMember myMember = new AccountMember(firstName);
    myList.add(myMember);
   }
  }
 }

}
