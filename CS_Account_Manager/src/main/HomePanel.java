import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Arrays;


public class HomePanel extends JFrame {

	// Create the TableView
	TableView<AccountMember> table = new TableView<>(TableViewHelper.getPersonList());

	
	
	private JPanel contentPane;
    
	
	public static void main(String[] args ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					HomePanel frame = new HomePanel();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	protected JButton View_Accounts, Add_Account, View_Transaction, Logout;
	public HomePanel() {

		// Turn on multi-row selection for the TableView
		TableViewSelectionModel<Person> tsm = table.getSelectionModel();
		tsm.setSelectionMode(SelectionMode.MULTIPLE);

		// Add columns to the TableView
		table.getColumns().addAll(TableViewHelper.getName(), TableViewHelper.getTotal());

		// Set the column resize policy to constrained resize policy
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		// Set the Placeholder for an empty table
		table.setPlaceholder(new Label("No visible columns and/or data exist."));

		// Create the GridPane
		GridPane newDataPane = this.getNewPersonDataPane();

		// Create the Delete Button and add Event-Handler
		Button deleteButton = new Button("Delete Selected Rows");
		deleteButton.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
                deletePerson();
            }
        });
		
		
		// Create the VBox
		VBox root = new VBox();
		// Add the GridPane and the Delete Button to the VBox
		root.getChildren().addAll(newDataPane, deleteButton, table);

		// Set the Padding and Border for the VBox
		root.setSpacing(5);
		// Set the Spacing and Border for the VBox
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

	public GridPane getNewPersonDataPane()
	{
		// Create the GridPane
		GridPane pane = new GridPane();

		// Set the hgap and vgap properties
		pane.setHgap(10);
		pane.setVgap(5);


		// Create the Add Button and add Event-Handler
		Button addButton = new Button("Add");
		addButton.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
                addPerson();
            }
        });

		// Add the Add Button to the GridPane
		pane.add(addButton, 2, 0);

		return pane;
	}

		public void addPerson()
	{

		 				//## create member ID
//		Integer currentId = 0;
//
//		// Get the next ID
//		for(Person p : table.getItems())
//		{
//			if(p.getId()>currentId)
//			{
//				currentId = p.getId();
//			}
//		}

		// Create a new Person Object
		Person person = new Person(Name, total);


		// Add the new Person to the table
		table.getItems().add(person);

		
	}

	public void deletePerson()
	{
		TableViewSelectionModel<Person> tsm = table.getSelectionModel();

		// Check, if any rows are selected
		if (tsm.isEmpty())
		{
			System.out.println("Please select a row to delete.");
			return;
		}

		// Get all selected row indices in an array
		ObservableList<Integer> list = tsm.getSelectedIndices();

		Integer[] selectedIndices = new Integer[list.size()];
		selectedIndices = list.toArray(selectedIndices);

		// Sort the array
		Arrays.sort(selectedIndices);

		// Delete rows (last to first)
		for(int i = selectedIndices.length - 1; i >= 0; i--)
		{
			tsm.clearSelection(selectedIndices[i].intValue());
			table.getItems().remove(selectedIndices[i].intValue());
		}
	}
}

////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////
		setTitle("CS-AccountManager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300,300));
		this.pack();
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		GridLayout grid = new GridLayout(5,1);
		
		JPanel panelLayout = new JPanel(grid);
		JPanel VA_Panel = new JPanel();
		JPanel AA_Panel = new JPanel();
		JPanel VT_Panel = new JPanel();
		JPanel LO_Panel = new JPanel();

		
		View_Accounts = new JButton("Voew Accounts");
		Add_Account = new JButton("Add Account");
		View_Transaction = new JButton("View Transactions");
		Logout = new JButton("Log out");
		
		this.add(panelLayout, BorderLayout.CENTER);
		VA_Panel.add(View_Accounts);
		panelLayout.add(VA_Panel);
		
		AA_Panel.add(Add_Account);
		panelLayout.add(AA_Panel);
		
		VT_Panel.add(View_Transaction);
		panelLayout.add(VT_Panel);
		
		LO_Panel.add(Logout);
		panelLayout.add(LO_Panel);
		
		View_Accounts.addActionListener(new BL());
		Add_Account.addActionListener(new BL());
		View_Transaction.addActionListener(new BL());
		Logout.addActionListener(new BL());
		
		
		
		//by Ali "Logo" "will added to each frame"
		  JPanel LogoPanel = new JPanel();
		  LogoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		  this.add(LogoPanel, BorderLayout.SOUTH);
		  LogoPanel.setPreferredSize(new Dimension(this.getWidth(), 16));
		  LogoPanel.setLayout(new BoxLayout(LogoPanel, BoxLayout.X_AXIS));
		  JLabel LogoLabel = new JLabel("Developed by 4Guys");
		  LogoPanel.add(LogoLabel);
		
		
		
	}
	
	private class BL implements ActionListener {
		
		public void actionPerformed (ActionEvent argo0) {
			
			if (argo0.getSource() == Logout ) 
			{
			System.exit(0);
			}
			
		}
	}
	

}
