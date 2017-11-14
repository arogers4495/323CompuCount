import java.awt.Color; 
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel; 
import java.awt.event.*;
import java.sql.ResultSet;


@SuppressWarnings("serial")
class DepartmentGui extends JFrame{   

      Connection con;
      Statement stmt;

       PreparedStatement preStatement,updatePreStmt;
      JLabel title, idLabel, coursenameLabel, Marks1Label, Marks2Label, TotalLabel;
      JTextField idField, coursenameField, Marks1Field, Marks2Field, TotalField;
      JButton registerButton, exitButton,updateButton,deleteButton,resetButton,
              refresh;
      JRadioButton csbranch, fecsbranch;
      ButtonGroup bg;
      JPanel panel;
      JTable table;

      DefaultTableModel model;

      JScrollPane scrollpane;
      public DepartmentGui() {
         
           super("University  CSAM INFORMATION");
            setSize(770, 420);
            setLayout(null);
           
            connect();
            
            title = new JLabel("University  CSAM INFORMATION");
            title.setBounds(60, 7, 200, 30);
            idLabel = new JLabel("ID");
            idLabel.setBounds(30, 50, 60, 20);
            coursenameLabel = new JLabel("Name"); 
            coursenameLabel.setBounds(30, 85, 60, 20);
            Marks1Label = new JLabel("Description"); 
            Marks1Label.setBounds(30, 155, 60, 20);
            Marks2Label = new JLabel("Amount"); 
            Marks2Label.setBounds(30, 185, 60, 20); 
            TotalLabel = new JLabel("Total"); 
            TotalLabel.setBounds(30, 210, 60, 20);

            
            idField = new JTextField(); 
            idField.setBounds(95, 50, 130, 30);
            idField.setEnabled(false);

            
            coursenameField = new JTextField(); 
            coursenameField.setBounds(95, 85, 130, 20);         

            
            csbranch = new JRadioButton("Credit Card 5%");
            csbranch.setBounds(95, 110, 160, 20);

            fecsbranch = new JRadioButton("Debit Card 0% ");
            fecsbranch.setBounds(95, 130, 140, 20);            
               
            bg = new ButtonGroup(); 
            bg.add(csbranch); 
            bg.add(fecsbranch); 
            Marks1Field=new JTextField();
        
            Marks1Field.setBounds(105, 165, 120, 20);
            Marks2Field = new JTextField(); 

            Marks2Field.setBounds(105, 190, 120, 20);
            TotalField = new JTextField(); 
            TotalField.setBounds(105, 220, 120, 20);
 
            
            add(title);
            add(idLabel);
            add(coursenameLabel);
            add(Marks1Label);
            add(Marks2Label);
            
            add(TotalLabel);
            add(idField);
            add(coursenameField);
            add(csbranch);
            add(fecsbranch);
            add(Marks1Field);

            add(Marks2Field);
            add(TotalField);

            // Defining Exit Button
            exitButton = new JButton("back"); 
            exitButton.setBounds(25, 250, 80, 25);            

            // Defining Register Button
            registerButton = new JButton("Register");
            registerButton.setBounds(110, 250, 100, 25);

            // Defining Update Button
            updateButton = new JButton("Update");
            updateButton.setBounds(110, 285, 100, 25);
            updateButton.setEnabled(false);

            // Defining Delete Button
            deleteButton = new JButton("Delete");
            deleteButton.setBounds(25, 285, 80, 25);
            deleteButton.setEnabled(false);

            // Defining Reset Button
            resetButton = new JButton("Reset");
            resetButton.setBounds(60, 320, 100, 25);
            resetButton.setEnabled(false); 

            // fixing all Buttons
            add(exitButton);
            add(registerButton);
            add(updateButton);
            add(deleteButton);
            add(resetButton);    

            // Defining Panel
            panel = new JPanel();
            panel.setLayout(new GridLayout());
            panel.setBounds(250, 20, 480, 330);
            panel.setBorder(BorderFactory.createDashedBorder(Color.blue));
            add(panel);

            // Defining Refresh Button
            refresh = new JButton("Refresh Table");
            refresh.setBounds(350, 350, 270, 15);
            add(refresh);

            //Defining Model for table
            model = new DefaultTableModel();

            //Adding object of DefaultTableModel into JTable
            table = new JTable(model);

            //Fixing Columns move
            table.getTableHeader().setReorderingAllowed(false);

            // Defining Column Names on model
            model.addColumn("S.No");
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Description");
            model.addColumn("Amount");
            model.addColumn("Total");
 
            // Enable Scrolling on table
           scrollpane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                           JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            panel.add(scrollpane);

            //Displaying Frame in Center of the Screen
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width/2-this.getSize().width/2,
                             dim.height/2-this.getSize().height/2);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setVisible(true);
      }

      // Connection with Database
      public void connect(){
            try{
                  Class.forName("com.mysql.jdbc.Driver");
                  con =DriverManager.getConnection( "jdbc:mysql://localhost:3306/","root","admin123");
                  stmt = con.createStatement();
                  preStatement = con.prepareStatement("insert into exams_details(coursename,Marks1,Marks2,Total) values(?,?,?,?)");
            }catch(Exception e){
                  System.out.print(e.getMessage());
            }
      }
}
 

@SuppressWarnings("serial")
 class DynamicRegForm extends DepartmentGui{
      String Marks1 = "";
      ResultSet rst,rstLast;
      Object[][] data;
      int serialNo; 
      String SHOW = "Show";
      DepartmentGui formGUIObject;

      // Defining Constructor
      DynamicRegForm(){
            coursenameField.addKeyListener(new KeyAdapter() {
                  public void keyTyped(KeyEvent e) {
                  if(coursenameField.getText().length()>=15)
                        e.consume();
                  }
            });
            csbranch.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        Marks1 = "csbranch";
                  }
            });
            fecsbranch.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        Marks1 = "Fecsbranch";
                  }
            });
            Marks2Field.addKeyListener(new KeyAdapter() {
                  public void keyTyped(KeyEvent e) {
                  if(Marks2Field.getText().length()>50)
                        e.consume();
                  }
            });
            TotalField.addKeyListener(new KeyAdapter() {
                  public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!((c >= '0') && (c <= '9') ||
                             (c == KeyEvent.VK_BACK_SPACE) ||
                             (c == KeyEvent.VK_DELETE))) {
                              // getToolkit().beep();
                              e.consume();
                        }
                        if(TotalField.getText().length()>9) 
                              e.consume();
                  }
            });
            exitButton.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent arg0) {
                        try{
                             // con.close();
                             // System.exit(0);
                                        new BackgroundImageJFrame();

                        }catch(Exception ex){
                               System.out.println(ex.getMessage());
                        }
                  }
            });
            registerButton.addActionListener(new AbstractAction(SHOW){
                   public void actionPerformed(ActionEvent ae){
                         try{
                            if (ae.getSource() == registerButton) {
                                if (coursenameField.getText().equals(""))
                                   JOptionPane.showMessageDialog(idField, 
                                               "Please provide Name_Field");
                                else if(Marks2Field.getText().equals(""))
                                   JOptionPane.showMessageDialog(idField, 
                                               "Please provide Description Information");
                                else if(TotalField.getText().equals(""))
                                   JOptionPane.showMessageDialog(idField, "Please provide Total_Field");
                                else if(Marks1.equals(""))
                                   JOptionPane.showMessageDialog(idField, "Please select Type");
                                else {
                                 //Fetching column values from Database
                                 preStatement.setString(1,coursenameField.getText());
                                 preStatement.setString(2,Marks1);
                                 preStatement.setString(3,Marks2Field.getText());
                                 preStatement.setString(4,TotalField.getText());
                               //Executing MySQL Update Query
                                 int i = preStatement.executeUpdate();
                                 if(i==1){
                                  JOptionPane.showMessageDialog(panel, 
                                               "Successfully Registered");
                                 }
 
                                 // showing last row 
                                rstLast = stmt.executeQuery("select *from exams_details");
                                rstLast.last();
String string = serialNo++ +","+String.valueOf(rstLast.getLong(1))+", "+rstLast.getString(2)+","+rstLast.getString(3)+","+rstLast.getString(4)+", "+rstLast.getString(5);
   
                                             
                                             
                                            
                 
                                 Object[] row = null;
                                 row = string.split(",");
                                 model.addRow(row);
                                 panel.revalidate();
 
                                 // fields are blank
                                 blankFields();
                               }
                              }
                       }catch(Exception ex){
                              System.out.println(ex.getMessage()); 
                       }
                   }
            });
 
            updateButton.addActionListener(new AbstractAction(SHOW){
              public void actionPerformed(ActionEvent e){
                  if (coursenameField.getText().equals(""))
                        JOptionPane.showMessageDialog(idField,
                                    "Please provide Name_Field");
                  else if(Marks2Field.getText().equals(""))
                        JOptionPane.showMessageDialog(idField,
                                    "Please provide Marks2_Field");
                  else if(TotalField.getText().equals(""))
                        JOptionPane.showMessageDialog(idField,
                                    "Please provide Total_Field");              
                  else if(Marks1.equals(""))
                        JOptionPane.showMessageDialog(idField,
                                    "Please select Marks1");                  
                  else {
                              int r = table.getSelectedRow();
                              try{
                              if(r>=0){
                                 if(csbranch.isSelected())
                                    Marks1 = csbranch.getText();
                                 else
                                    Marks1 = fecsbranch.getText();
                                    String id = (String)table.getModel().
                                                              getValueAt(r,1);
                                    updatePreStmt = con.prepareStatement(  "update exams_details set coursename=?, Marks1=?,Marks2=?,Total=?where id="+id);

                                                   
                                                  
                                     updatePreStmt.setString(1,coursenameField.getText());
                                  updatePreStmt.setString(2,Marks1);
                                  updatePreStmt.setString(3,Marks2Field.getText());
                                  updatePreStmt.setString(4,TotalField.getText());
                                  int i = updatePreStmt.executeUpdate();
                                  if(i==1){
                                     table.setValueAt(coursenameField.getText(),r,2);
                                     table.setValueAt(Marks1, r, 3);
                                     table.setValueAt(Marks2Field.getText(),r,4);
                                     table.setValueAt(TotalField.getText(), r, 5);
                                  }
                                  else JOptionPane.showMessageDialog(panel,  "ID does't Exists in Database");
                              }
                              }catch(Exception ex){
                                      System.out.println("Update section: "+  ex.getMessage()); 
                              }
                        }
              }
          });
 
            //Registering Anonymous Listener Class
            deleteButton.addActionListener(new AbstractAction(SHOW){ 
              public void actionPerformed(ActionEvent e){
                  try{ 
                  //Getting Selected Row No
                  int r = table.getSelectedRow(); 
                  if(r>=0){ 
                        if (JOptionPane.showConfirmDialog(panel,"Are you sure want to Delete this 'RECORD' ?","WARNING",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                              String id = (String)table.getModel().getValueAt(r,1);
 
                              // Executing MySQL Update Command
                              int i = stmt.executeUpdate("delete from exams_details  where id="+id);
                              if(i==1){
                                    model.removeRow(r);
 
                                    // fields are blank
                                    blankFields();
                                    registerButton.setEnabled(true);
                                    deleteButton.setEnabled(false);
                                    updateButton.setEnabled(false);
                              }
                        }
                  }
                  }catch(Exception ex){
                         System.out.println(ex.getMessage());
                  }
              }
          });
 
           //Registering Anonymous Listener Class
            resetButton.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent arg0) {
                        // calling method resetFields()
                        resetFields();
                        registerButton.setEnabled(true);
                        updateButton.setEnabled(false);
                        deleteButton.setEnabled(false);
                        resetButton.setEnabled(false);
                  }
            });

            // Registering Anonymous Listener Class
            refresh.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent arg0) {
                        //calling  refresh() method
                        refreshTable();
                  }
            });

            //Registering Anonymous Listener Class
            table.addMouseListener(new MouseListener(){
                  public void mouseClicked(MouseEvent arg0){ 
                        //Getting Selected Row No
                  int r = table.getSelectedRow();
                  if(r>=0){ 
                        deleteButton.setEnabled(true);
                        updateButton.setEnabled(true);
                        resetButton.setEnabled(true);
                        registerButton.setEnabled(false); 

                        //Fetching records from Table on Fields
                        idField.setText(""+table.getModel().getValueAt(r,1));
                        coursenameField.setText(""+table.getModel().getValueAt(r,2));
                        if(table.getModel().getValueAt(r,3).equals("csbranch"))
                              csbranch.setSelected(true);
                        else
                              fecsbranch.setSelected(true);
                        Marks2Field.setText(""+table.getModel().getValueAt(r,4));
                        TotalField.setText(""+table.getModel().getValueAt(r,5));
                  }
                  }

//                @Override
                  public void mouseReleased(MouseEvent arg0) {}
//                @Override
                  public void mousePressed(MouseEvent arg0) {}
//                @Override 
                  public void mouseExited(MouseEvent arg0) {}
//                @Override 
                  public void mouseEntered(MouseEvent arg0) {}
            });

            // Displaying rows into the Frame table
            addRows();
      }

      // addRows method
      private void addRows(){
            try{
            Object[] row = null;
            //Generating Serial No
            serialNo=1;
            rst = stmt.executeQuery("select *from exams_details");
            while(rst.next()){ 
                  String string = serialNo++ +","+String.valueOf(rst.getLong(1))+","+rst.getString(2)+","+rst.getString(3)+","+rst.getString(4)+","+rst.getString(5);
         
                                           row = string.split(",");

                  // Adding records in table model 
                  model.addRow(row);
            }
            panel.revalidate();
            }catch(Exception ex){ System.out.println(ex.getMessage()); }
      }

      private void resetFields(){ 
 
            //calling method blankfields() 
            blankFields();
      }
 
      // refresh method
      private void refreshTable(){
 
            // removing all the rows of the table
            DefaultTableModel dm = (DefaultTableModel)table.getModel();
            dm.getDataVector().removeAllElements();
            System.out.println("Refresh Table");

            //calling method addRows
            addRows();
      }

      private void blankFields(){
            // fields will be blank
            idField.setText("");
            coursenameField.setText("");
            Marks1 = "";
            bg.clearSelection();
            Marks2Field.setText("");
            TotalField.setText("");
      }

      // main() method
      public static void main(String[] args) {
            new DynamicRegForm();
      }     
}
