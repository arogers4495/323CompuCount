import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewAccountMember extends JPanel {
 private AccountMember member;
 private JLabel displayName;
 private JButton homeButton, deleteAccount;
 public JFrame mainFrame, warning;

 public ViewAccountMember() {
  displayName = new JLabel(member.getLastName());// sets the label text to the member's name
  homeButton = new JButton("Log Out");// initializes the Log Out button
  deleteAccount = new JButton("Delete Account");// initializes the Delete Account button
  this.add(displayName);// add the label to the panel
  this.add(homeButton);// add the Log Out button to the panel
  this.add(deleteAccount);// add the Delete Account button to the panel
  this.setVisible(true);// panel is visible
  this.setPreferredSize(new Dimension(500, 500));
  homeButton.addActionListener(new home());
  deleteAccount.addActionListener(new deleteAccount());
 }

 // The method below will take the user to the initial view
 private class home implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent arg0) {
  }

 }

 private class deleteAccount implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent arg0) {
   JLabel warningMessage = new JLabel("Are you sure you want to delete this account?");
   JPanel warningPanel = new JPanel();
   JButton proceed, cancel;
   proceed = new JButton("OK");
   cancel = new JButton("Cancel");
   proceed.addActionListener(new Proceed());
   cancel.addActionListener(new Cancel());
   warning = new JFrame();
   warning.setVisible(true);
   warning.add(warningPanel);
   warning.setSize(300, 200);
   warningPanel.add(warningMessage);
   warningPanel.add(proceed);
   warningPanel.add(cancel);
   warning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private class Proceed implements ActionListener {

   @Override
   public void actionPerformed(ActionEvent e) {
    warning.dispose();
   }

  }

  private class Cancel implements ActionListener {

   @Override
   public void actionPerformed(ActionEvent e) {
    warning.dispose();
   }

  }
 }

 // the main method below is for unit testing
 public static void main(String[] args) {
  JFrame testFrame = new JFrame();
  ViewAccountMember x = new ViewAccountMember();
  testFrame.getContentPane().add(x);
  testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  testFrame.setVisible(true);
  testFrame.pack();
 }
}
