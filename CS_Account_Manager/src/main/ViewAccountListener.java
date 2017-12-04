import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewAccountListener implements EventHandler<ActionEvent>{

    private Button addButton;
    LocalDate localDate;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    Transaction tran;
    AccountMember member;
    
    public ViewAccountListener(Button addButton, AccountMember member) {
        
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        localDate = LocalDate.now();
        this.addButton = addButton;
        this.member = member;
        
    }

    @Override
    public void handle(ActionEvent event) {
        
        if(event.getSource() == addButton) {
            
            Stage popupwindow = new Stage();
            
            BorderPane bp = new BorderPane();
            
            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Add Transaction");                   
                 
            Button button1 = new Button("Enter");
            
            Label lPrompt = new Label();
            Label lAmount = new Label("Amount");
            Label labelType = new Label("Type");
            Label labelInorOut = new Label("Withdrawl/" + "\n" + "Deposit");
            Label code = new Label("Code");
            
            TextField amount = new TextField(); 
            
            ComboBox<String> codeBox = new ComboBox<String>();
            codeBox.getItems().addAll("MAF654845","KTO987856","HJT12478555");
            codeBox.setEditable(true);
            
            ComboBox<String> typeBox = new ComboBox<String>();
            typeBox.getItems().addAll("Card","Cash","Check");
            typeBox.setEditable(true);
            
            ComboBox<String> dwBox = new ComboBox<String>();
            dwBox.getItems().addAll("Withdrawl","Deposit");
            dwBox.setEditable(true);
            
            HBox hbox = new HBox();
            hbox.setAlignment(Pos.BOTTOM_RIGHT);
            hbox.getChildren().add(button1);
            
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.TOP_LEFT);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));
            
            grid.add(lPrompt, 1, 0);
            grid.add(lAmount, 0, 1);
            grid.add(amount, 1, 1);
            grid.add(labelType, 0, 2);
            grid.add(typeBox, 1, 2);
            grid.add(code, 0, 3);
            grid.add(codeBox, 1, 3);
            grid.add(labelInorOut, 0, 4);
            grid.add(dwBox, 1, 4);
            grid.add(hbox, 1, 5);
            
            bp.setCenter(grid);
            
            Scene scene = new Scene(bp, 300, 250);
            
            button1.setOnAction(e -> {

                if (amount.getText().trim().isEmpty() || typeBox.getSelectionModel().isEmpty() || codeBox.getSelectionModel().isEmpty() || 
                        dwBox.getSelectionModel().isEmpty()) {

                    lPrompt.setText("*All Fields Required!");
                    lPrompt.setFont(Font.font("Verdana", 12));
                    lPrompt.setTextFill(Paint.valueOf("RED"));
                    amount.clear();


                   } else {

                    
                            tran =new Transaction(
                      
                      localDate,
                      codeBox.getSelectionModel().getSelectedItem().toString(),
                      amount.getText(),
                      typeBox.getSelectionModel().getSelectedItem().toString(),
                      dwBox.getSelectionModel().getSelectedItem().toString()

                    );
                   
                            ViewAccountScene.data.add(tran);

                    if (dwBox.getSelectionModel().getSelectedItem() == "Deposit") {

                        ViewAccountScene.total = ViewAccountScene.total +  Double.parseDouble(amount.getText());
                     
                        ViewAccountScene.labelTotal.setText("Total: " + ViewAccountScene.total);
                        
                        try {
                            AccountsFile.deposit(member, tran);
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                    } else {

                        ViewAccountScene.total = ViewAccountScene.total - Double.parseDouble(amount.getText());
                        
                        ViewAccountScene.labelTotal.setText("Total: " + ViewAccountScene.total);
                        
                        try {
                            AccountsFile.withdraw(member, tran);
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                    }

                 popupwindow.close();

                }

               });
            
            popupwindow.setScene(scene);
            popupwindow.showAndWait();
            
        }
        
    }

}
