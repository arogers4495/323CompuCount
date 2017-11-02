import java.awt.CardLayout;

import javax.swing.JPanel;

public class Clayout {

 private CardLayout cl;
 private JPanel container = new JPanel();

 public Clayout() {
     
     cl = new CardLayout();
     container.setLayout(cl);
     
     
 }
 
 public JPanel Show() {
     
     return container;
     
 }

 public void AddPanel(JPanel panel, String name) {

     container.add(panel, name);
    
}
 
 public void ChangePanel(String name){
     
     cl.show(container, name);
     
 }

}
