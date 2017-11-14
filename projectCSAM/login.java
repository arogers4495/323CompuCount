import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import java.security.MessageDigest;
import java.util.*;


 class login extends JFrame {
  JButton blogin;
  JPanel loginpanel;
  JTextField txuser;
  JTextField pass;
  JButton newUSer;
  JLabel username;
  JLabel password;

String mdfconvet(String ppaswder)
{


try {
            // Create MessageDigest instance for MD5
                    String passwordToHash = "password";
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            ppaswder = sb.toString();
        } 
        catch (Exception ep) 
        {
            ep.printStackTrace();
        }
        
return ppaswder;





}
  public login(){
    super("Login Autentification");

    blogin = new JButton("Login");
    loginpanel = new JPanel();
    txuser = new JTextField(15);
    pass = new JPasswordField(15);
    newUSer = new JButton("Account Setting User?");
    username = new JLabel("User - ");
    password = new JLabel("Pass - ");

    setSize(300,200);
    setLocation(500,280);
    loginpanel.setLayout (null); 


    txuser.setBounds(70,30,150,20);
    pass.setBounds(70,65,150,20);
    blogin.setBounds(110,100,180,20);
    newUSer.setBounds(110,135,180,20);
    username.setBounds(20,28,80,20);
    password.setBounds(20,63,80,20);

    loginpanel.add(blogin);
    loginpanel.add(txuser);
    loginpanel.add(pass);
    loginpanel.add(newUSer);
    loginpanel.add(username);
    loginpanel.add(password);

    getContentPane().add(loginpanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("userPass.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("userPass.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }




    blogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          File file = new File("userPass.txt");
          Scanner scan = new Scanner(file);;
          String line = null;
          FileWriter filewrite = new FileWriter(file, true);

          String usertxt = " ";
          String passtxt = " ";
          String puname = txuser.getText();
          String ppaswd = pass.getText();
ppaswd=mdfconvet(ppaswd);

          while (scan.hasNext()) {
            usertxt = scan.nextLine();
            passtxt = scan.nextLine();

          }




          if(puname.equals(usertxt) && ppaswd.equals(passtxt)) {
       
                       
            JOptionPane.showMessageDialog(null," Username and Password checked");

             
            	new BackgroundImageJFrame();

          } 
          else if(puname.equals("") && ppaswd.equals("")){
            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
          }
          else {

            JOptionPane.showMessageDialog(null,"Wrong Username / Password");
            txuser.setText("");
            pass.setText("");
            txuser.requestFocus();
          }
        } catch (IOException d) {
          d.printStackTrace();
        }

      }
    });

    newUSer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        NewUser user = new NewUser();
        dispose();

      }
    });
  } 

}

class NewUser extends JFrame {
  JButton create;
  JPanel newUserPanel;
  JTextField txuserer;
  JTextField passer;
public static void main(String args[])
{
login  l = new login();

}

  public NewUser(){
    super("Registration");

    create = new JButton("Create");
    newUserPanel = new JPanel();
    txuserer = new JTextField(15);
    passer = new JPasswordField(15);


    setSize(300,200);
    setLocation(500,280);
    newUserPanel.setLayout (null); 


    txuserer.setBounds(70,30,150,20);
    passer.setBounds(70,65,150,20);
    create.setBounds(110,100,80,20);

    newUserPanel.add(create);
    newUserPanel.add(txuserer);
    newUserPanel.add(passer);

    getContentPane().add(newUserPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("userPass.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("userPass.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }




    create.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
    File file = new File("userPass.txt");
    Scanner scan = new Scanner(file);;

      FileWriter filewrite = new FileWriter(file, true);

      String usertxter = " ";
      String passtxter = " ";
      String punamer = txuserer.getText();
      String ppaswder = passer.getText();
      while (scan.hasNext()) {
        usertxter = scan.nextLine();
        passtxter = scan.nextLine();
      }

        if(punamer.equals(usertxter) && ppaswder.equals(passtxter)) {
           JOptionPane.showMessageDialog(null,"Username is already in use");
          txuserer.setText("");
          passer.setText("");
          txuserer.requestFocus();

        } 
        else if(punamer.equals("") && ppaswder.equals("")){
        JOptionPane.showMessageDialog(null,"Please insert Username and Password");
        }
        else {
        
        try {
            // Create MessageDigest instance for MD5
                    String passwordToHash = "password";
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            ppaswder = sb.toString();
        } 
        catch (Exception ep) 
        {
            ep.printStackTrace();
        }
                filewrite.write(punamer+"\r\n" +ppaswder+ "\r\n");
        filewrite.close();
        JOptionPane.showMessageDialog(null,"Trish has been created.");
        dispose();
        login log = new login();



        }
        } catch (IOException d) {
      d.printStackTrace();
    }

      }
    });
  } 

}




class BackgroundImageJFrame extends JFrame implements ActionListener
{
JButton b1;
JButton l1,l2,l3;
	public BackgroundImageJFrame()
	{
	setTitle("CSAM System Carrer Summer and Fare Mangement System");
	setSize(400,400);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);

	setLayout(new BorderLayout());
	setContentPane(new JLabel(new ImageIcon("b2.jpg")));
	setLayout(new FlowLayout());
	l1=new JButton("Trish");
	b1=new JButton("Department");
   l2=new JButton("University Transaction System");
   l3=new JButton("about");

   
	add(l1);
	add(b1);
   add(l2);
   add(l3);
   b1.addActionListener(this);
   l1.addActionListener(this);
   l2.addActionListener(this);
   l3.addActionListener(this);

   
	// Just for refresh :) Not optional!
	setSize(399,399);
	setSize(400,400);
	}
   public void actionPerformed(ActionEvent ae)
   {
   if(ae.getSource().equals(l1))
   {
            new DynamicRegForm();
   }
   if(ae.getSource().equals(b1))
   {
   
		SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				new DepartmentGui();
			}
		}); }  
       if(ae.getSource().equals(l2))
   {
SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				new CSAMPvt();
			}
		});   }
  
             if(ae.getSource().equals(l3))
   {
      			JOptionPane.showMessageDialog(null, "CSAM System by seth1.thompson@umontana.edu ali.alzarra@umontana.edu \njoshua.timm@umontana.edu\nauston.rogers@umconnect.umt.e."+"\nFor further help MYEMAIL:"+"\nseth1.thompson@umontana.edu");

      }
       }
	}
