import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class Clayout {
    
    private CardLayout cl;
    private JPanel container = new JPanel();
    
    public Clayout() {
        
        LoginPanel loginp = new LoginPanel();
        HomePanel home = new HomePanel();
        CreateMemberPanel cmPanel = new CreateMemberPanel();
        ViewAccountMember vaMember = new ViewAccountMember();
        
        container.setLayout(cl);
        
        container.add(loginp, "1");
        container.add(home, "2");
        container.add(cmPanel, "3");
        container.add(vaMember, "4");
        
    }
    
    public Component Show(String num) {
        
         cl.show(container, num);
        
    }

}
