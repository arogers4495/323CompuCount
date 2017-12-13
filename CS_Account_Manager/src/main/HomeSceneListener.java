import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeSceneListener implements EventHandler<ActionEvent>{

    private Button viewAccount, addAccount, delAccount, viewReport;
    private TableView<AccountMember> table;
    static AccountMember member;
    private final TableView<Transaction> table2 = new TableView();
    static ObservableList<Transaction> data;
    private TableColumn<Transaction, String> dateCol, descriptionCol, amountCol, typeCol, WithdrawlDepositCol;
    private Label transactionLabel;
    
    public HomeSceneListener(Button viewAccount, Button addAccount, Button delAccount, TableView<AccountMember> table, Button viewButton) {
        
        this.viewReport = viewButton;
        this.viewAccount = viewAccount;
        this.addAccount = addAccount;
        this.delAccount = delAccount;
        this.table = table;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void handle(ActionEvent event) {
       
        if(event.getSource() == viewAccount) {
            
            if(table.getSelectionModel().getSelectedItem() == null) {
                
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Selection Error!");
                alert.setHeaderText(null);
                alert.setContentText("Please Select A Member To View!");
                alert.showAndWait();
                
            }
            else{
                
                member = table.getSelectionModel().getSelectedItem();
            
                SceneController.ShowViewAccountScene();
            }
            
        }
        
        if(event.getSource() == delAccount) {
            
            if(table.getSelectionModel().getSelectedItem() == null) {
                
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Selection Error!");
                alert.setHeaderText(null);
                alert.setContentText("Please Select A Member To Delete!");
                alert.showAndWait();
                
            }
            else{
                
                member = table.getSelectionModel().getSelectedItem();
            
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Delete!");
                alert.setHeaderText(null);
                alert.setContentText(member.getName() + " Will be Deleted!");
                
                Optional<ButtonType> result = alert.showAndWait();
                
                if (result.get() == ButtonType.OK){
                    
                    Alert alert2 = new Alert(AlertType.CONFIRMATION);
                    alert2.setTitle("Delete!");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Are You Sure!");
                    
                    Optional<ButtonType> result2 = alert2.showAndWait();
                    
                    if(result2.get() == ButtonType.OK)
                        
                    AccountsFile.deleteMember(member);
                    HomeScene.data.remove(member);
                    alert2.close();
                    
                    
                } else {
                    alert.close();
                }
                
            }
            
        }
        
        if(event.getSource() == viewReport) {
            
            HBox hb = new HBox();
            hb = new HBox();
            hb.setSpacing(3);
            
            Stage popupwindow = new Stage();
            
            BorderPane bp = new BorderPane();
            
            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Add Transaction");                   
                 
            Button button1 = new Button("Print");
            
            transactionLabel = new Label("Transactions");

            table2.setEditable(true);

            transactionLabel = new Label("Transactions");
            dateCol = new TableColumn<Transaction, String>("Date");
            descriptionCol = new TableColumn<Transaction, String>("Description");
            amountCol = new TableColumn<Transaction, String>("Amount");
            typeCol = new TableColumn<Transaction, String>("Type");
            WithdrawlDepositCol = new TableColumn<Transaction, String>("Deposit/Withdrawl");
            
            transactionLabel.setFont(new Font("Arial", 20));
            
            table2.getColumns().addAll(descriptionCol, amountCol, dateCol, typeCol, WithdrawlDepositCol);
            
            dateCol.setMinWidth(99);
            dateCol.setCellValueFactory(
                    new PropertyValueFactory<>("Date"));

            
            descriptionCol.setMinWidth(100);
            descriptionCol.setCellValueFactory(
                    new PropertyValueFactory<>("Description"));

            
            amountCol.setMinWidth(100);
            amountCol.setCellValueFactory(
                    new PropertyValueFactory<>("Amount"));
            
            typeCol.setMinWidth(99);
            typeCol.setCellValueFactory(
                    new PropertyValueFactory<>("Type"));
            
            WithdrawlDepositCol.setMinWidth(150);
            WithdrawlDepositCol.setCellValueFactory(
                    new PropertyValueFactory<>("WithdrawlDeposit"));
            
            table2.setItems(data);

            hb.getChildren().add(button1);
            
            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(transactionLabel, table2, hb);
            
            bp.setCenter(vbox);
            
            Scene scene = new Scene(bp, 1000, 800);
            
            popupwindow.setScene(scene);
            popupwindow.showAndWait();
        }
        
        if(event.getSource() == addAccount) {
            
            SceneController.ShowCreateMember();
            
        }
        
        
    }

}
