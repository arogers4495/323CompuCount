import java.awt.CardLayout;

import javax.swing.JPanel;

public class Clayout {
    
    private CardLayout cl;
    private JPanel container;
    private String panel;
    public Clayout() {
        
        cl = new CardLayout();
        container = new JPanel();
        container.setLayout(cl);      
        
    }
    
    public JPanel Show(){
        
        cl.show(container, panel);
        return container;
        
    }
    
    public void changePanel(String name) {
        
        panel = name;
       cl.show(container, panel);
        
    }    
    
    public void AddPanel(JPanel newPanel, String name) {
        
        container.add(newPanel, name);
        
    }
    

}
