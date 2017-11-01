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

 private JLabel firstNameLabel, lastNameLabel, phoneNumLabel, emailLabel, descriptionLabel;
 private JTextField firstNameTField, lastNameTField, phoneNumTField, emailTField, descriptionTField;
 private JButton submit, home;
 private String firstName, lastName, phoneNum, email, description;

 //ArrayList<AccountMember> myList = new ArrayList<AccountMember>();

 public void createAccount(AccountMember NewMember) {

 }

 public CreateMemberPanel() {

  firstNameLabel = new JLabel("First Name:");
  lastNameLabel = new JLabel("Last Name:");
  phoneNumLabel = new JLabel("Phone Number:");
  emailLabel = new JLabel("Email:");
  descriptionLabel = new JLabel("Description:");

  firstNameTField = new JTextField(10);
  lastNameTField = new JTextField(10);
  phoneNumTField = new JTextField(10);
  emailTField = new JTextField(10);
  descriptionTField = new JTextField(10);

  submit = new JButton("Submit");
  home = new JButton("Home");

  ButtonListener listener = new ButtonListener();
  submit.addActionListener(listener);
  home.addActionListener(listener);

  setPreferredSize(new Dimension(500, 500));
  setBackground(Color.WHITE);

  this.setLayout(new BorderLayout());
  GridLayout grid = new GridLayout(1, 1);
  JPanel panelLayout = new JPanel(grid);

  JPanel firstNamePanel = new JPanel();
  JPanel lastNamePanel = new JPanel();
  JPanel phoneNumPanel = new JPanel();
  JPanel emailPanel = new JPanel();
  JPanel descriptionPanel = new JPanel();


  JPanel sButtonPanel = new JPanel();
  JPanel hButtonPanel = new JPanel();

  this.add(panelLayout, BorderLayout.CENTER);

  firstNamePanel.add(firstNameLabel);
  firstNamePanel.add(firstNameTField);
  panelLayout.add(firstNamePanel);

  lastNamePanel.add(lastNameLabel);
  lastNamePanel.add(lastNameTField);
  panelLayout.add(lastNamePanel);

  phoneNumPanel.add(phoneNumLabel);
  phoneNumPanel.add(phoneNumTField);
  panelLayout.add(phoneNumPanel);

  emailPanel.add(emailLabel);
  emailPanel.add(emailTField);
  panelLayout.add(emailPanel);

  descriptionPanel.add(descriptionLabel);
  descriptionPanel.add(descriptionTField);
  panelLayout.add(descriptionPanel);

  sButtonPanel.add(submit);
  panelLayout.add(sButtonPanel);

  hButtonPanel.add(home);
  panelLayout.add(hButtonPanel);

 }

 private class ButtonListener implements ActionListener {
  public void actionPerformed(ActionEvent event) {
   String firstName, lastName, phoneNum, email, description;

   firstName = firstNameTField.getText();
   lastName = lastNameTField.getText();
   phoneNum = phoneNumTField.getText();
   email = emailTField.getText();
   description = descriptionTField.getText();


   if (event.getSource() == home){
    System.out.println("home");
  }
   if (event.getSource() == submit) {
     if(firstName.equals("")){
       firstNameTField.setBackground(Color.red);
     }
     if(lastName.equals("")){
       lastNameTField.setBackground(Color.red);
     }
     if(phoneNum.equals("")){
       phoneNumTField.setBackground(Color.red);
     }
     if(email.equals("")){
       emailTField.setBackground(Color.red);
     }
     if(description.equals("")){
       descriptionTField.setBackground(Color.red);
     }
     if (firstName.equals("") || lastName.equals("") || phoneNum.equals("") || email.equals("") || description.equals("")){
      JOptionPane.showMessageDialog(null, "Please complete ALL fields");
    }
    else{
      System.out.println("submit");


    AccountMember myMember = new AccountMember(firstName);
    //myList.add(myMember);
  }
   }
  }
 }

}
