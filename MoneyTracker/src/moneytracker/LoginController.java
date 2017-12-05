/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneytracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */
public class LoginController implements Initializable {
    
    @FXML
    private Button login_about;
    @FXML
    private Button login;
    @FXML
    private CheckBox login_rememberName;
    @FXML
    private CheckBox login_rememberPassword;
    
    @FXML
    private TextField login_name;
    @FXML
    private PasswordField login_password;
    @FXML
    private Button about_back;
    @FXML
    private Button home_logout;
    @FXML
    private Button home_add;
    @FXML
    private Button home_delete;
    @FXML
    private Button home_percentage;
    
    @FXML
    private Button signup_add;
    @FXML
    private TextField signup_name;
     @FXML
    private TextField signup_password;
    @FXML
    private Label home_name;
    @FXML
     private TextField delete_name;
    @FXML
     private Button delete;
    @FXML
     private Label delete_data;
    @FXML
    
    private ListView<String> friends=new ListView<String>();
    private ObservableList<String> users1;
    
    

//Chat conversation end
//Type a message...
@FXML
     private void setlabel(String s)
    {
        home_name.setText(s);
    }
     private void settable() throws FileNotFoundException, IOException
     {
         FileReader fr = null;
                fr = new FileReader("config.txt");
          BufferedReader br=null;
          String sCurrentLine; 
            br=new BufferedReader(fr);
            
            
            
               ObservableList<String> users1;
               ArrayList<String > vec=new ArrayList<String>();
               
			while ((sCurrentLine = br.readLine()) != null) {
                            
                              vec.add(sCurrentLine);
                            
                            users1 =FXCollections.observableArrayList(vec);
                            
                            
                            
                          friends.setEditable(true);
                                                      friends.setItems(users1);
                            
                            }
                        
            
     }
     private void enterData(String a) throws IOException
     {
          System.out.println("File open successfully");
        System.out.println(a);
        File file=new File("config.txt");
       
        FileWriter fw = new FileWriter (file,true); 
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(a);
        bw.newLine();
        //bw.write('\n');
        System.out.println("File written successfully");
        
        bw.close();
        fw.close();
     }
     @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
         Stage stage;
        Parent root;
        if(event.getSource()==login_about)
        {
            stage=(Stage)login_about.getScene().getWindow();
                    root=FXMLLoader.load(getClass().getResource("AboutPage.fxml"));
                    Scene sc=new Scene(root);
                    stage.setScene(sc);
                    stage.show();
        }
        else if(event.getSource()==login)
        {
            String name=login_name.getText();
            String password=login_password.getText();
            if(name.equals("csadmin")&& password.equals("csci323"))
            {
                 stage=(Stage)login.getScene().getWindow();
                    FXMLLoader loader=new  FXMLLoader();
                    loader.setLocation(getClass().getResource("Home.fxml"));
                    loader.load();
                    LoginController lg= loader.getController();
                    lg.setlabel("CS Admin");
                    lg.settable();
                    root=loader.getRoot();
                    Scene sc=new Scene(root);
                    stage.setScene(sc);
                    stage.show();
                    
            }
            /*if(login_rememberName.isSelected())
            {
                
            }*/
            
            
            
            
        }
        else if(event.getSource()==about_back)
        {
             stage=(Stage)about_back.getScene().getWindow();
                    root=FXMLLoader.load(getClass().getResource("Login.fxml"));
                    Scene sc=new Scene(root);
                    stage.setScene(sc);
                    stage.show();
        }
        
        else if(event.getSource()==signup_add)
        {
            String name=signup_name.getText();
            String password=signup_password.getText();
            
            enterData((name+" "+password));
           stage=(Stage)signup_add.getScene().getWindow();
                    FXMLLoader loader=new  FXMLLoader();
                    loader.setLocation(getClass().getResource("Home.fxml"));
                    loader.load();
                    LoginController lg= loader.getController();
                    lg.setlabel("CS Admin");
                    lg.settable();
                    root=loader.getRoot();
                    Scene sc=new Scene(root);
                    stage.setScene(sc);
                    stage.show();
        }
        else if(event.getSource()==home_logout)
        {
              stage=(Stage)home_logout.getScene().getWindow();
                    root=FXMLLoader.load(getClass().getResource("Login.fxml"));
                    Scene sc=new Scene(root);
                    stage.setScene(sc);
                    stage.show();
        }
        else if(event.getSource()==home_delete)
        {
            stage=(Stage)home_delete.getScene().getWindow();
                    root=FXMLLoader.load(getClass().getResource("delete.fxml"));
                    Scene sc=new Scene(root);
                    stage.setScene(sc);
                    stage.show();
            
        }
        else if(event.getSource()==delete)
        {
            String name=delete_name.getText();
            
            BufferedReader br;
             br = null;
		FileReader fr = null;
                fr = new FileReader("config.txt");
          
            br=new BufferedReader(fr);
    	
			String sCurrentLine;
                FileWriter fw = new FileWriter ("temp.txt",true); 
                BufferedWriter bw = new BufferedWriter(fw);
        
               
			while ((sCurrentLine = br.readLine()) != null) {
                            String[] words=sCurrentLine.split(" ");
                            System.out.println(name);
                            if(words[0].equals(name))
                            {
                                
                            }
                            else
                            {
                                 bw.write(sCurrentLine);
                                 bw.newLine();
                            }
                            
				
			}
                    bw.close();
                    fw.close();
                    fr.close();
                    br.close();
                   
                   File fp=new File("config.txt");
                   fp.delete();
                    
                    
                    BufferedReader br1;
             br1 = null;
		FileReader fr1 = null;
                fr1 = new FileReader("temp.txt");
                 br1=new BufferedReader(fr1);
          
                      FileWriter fw1 = new FileWriter ("config.txt"); 
                BufferedWriter bw1 = new BufferedWriter(fw1);
        
               
			while ((sCurrentLine = br1.readLine()) != null) {
                           
                     bw1.write(sCurrentLine);
                                 bw1.newLine();
                    
                        }
                        bw1.close();
                    fw1.close();
                    fr1.close();
                    br1.close();
                   
                          File fp1=new File("temp.txt");
                   fp1.delete();
                    
                      //p.delete();fp.delete();
                      
                     stage=(Stage)delete.getScene().getWindow();
                    FXMLLoader loader=new  FXMLLoader();
                    loader.setLocation(getClass().getResource("Home.fxml"));
                    loader.load();
                    LoginController lg= loader.getController();
                    lg.setlabel("CS Admin");
                    lg.settable();
                    root=loader.getRoot();
                    Scene sc=new Scene(root);
                    stage.setScene(sc);
                    stage.show();
                    
                    
                    
        }
		

// File (or directory) with new name

        
    }
    @FXML
     private void handleAddMember(ActionEvent event) throws IOException {
         Stage stage;
        Parent root;
        if(event.getSource()==home_add)
        {
              stage=(Stage)home_add.getScene().getWindow();
                    root=FXMLLoader.load(getClass().getResource("temp.fxml"));
                    Scene sc=new Scene(root);
                    stage.setScene(sc);
                    stage.show();
        }
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
