import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewAccountListener implements EventHandler<ActionEvent> {

 private Button addButton, editButton;
 LocalDate localDate;
 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
 Transaction tran;
 AccountMember member;

 public ViewAccountListener(Button addButton, Button editButton, AccountMember member) {

  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  localDate = LocalDate.now();
  this.addButton = addButton;
  this.editButton = editButton;
  this.member = member;

 }

 @Override
 public void handle(ActionEvent event) {
AccountsFile.removeFile(member);
  if (event.getSource() == editButton) {
   FileWriter w = null;
   try {
    w = new FileWriter(AccountsFile.mainFile);
   } catch (IOException e3) {
    e3.printStackTrace();
   }
   BufferedWriter bw = new BufferedWriter(w);
   Stage editWin = new Stage();
   Label firstName = new Label("First Name:"), lastName = new Label("Last Name:"), email = new Label("eMail:"),
     phone = new Label("Phone:"), description = new Label("Description");
   TextField fText = new TextField(member.firstName), lText = new TextField(member.lastName),
     eText = new TextField(member.email), pText = new TextField(member.getPhone()),
     dText = new TextField(member.getDescription());

   Button update = new Button("Update information");

   BorderPane bp = new BorderPane();

   firstName.setPadding(new Insets(10, 10, 10, 10));
   lastName.setPadding(new Insets(10, 10, 10, 10));
   email.setPadding(new Insets(10, 10, 10, 10));
   phone.setPadding(new Insets(10, 10, 10, 10));
   description.setPadding(new Insets(10, 10, 10, 10));

   fText.setPadding(new Insets(10, 10, 10, 10));
   lText.setPadding(new Insets(10, 10, 10, 10));
   eText.setPadding(new Insets(10, 10, 10, 10));
   pText.setPadding(new Insets(10, 10, 10, 10));
   dText.setPadding(new Insets(10, 10, 10, 10));

   update.resize(20, 10);

   editWin.initModality(Modality.APPLICATION_MODAL);
   editWin.setTitle("Edit " + member.firstName);
   HBox h = new HBox();
   h.setPadding(new Insets(10, 10, 10, 10));
   VBox v = new VBox();
   VBox v2 = new VBox();
   h.getChildren().addAll(v, v2);
   v.getChildren().addAll(firstName, lastName, email, phone, description);
   v2.getChildren().addAll(fText, lText, eText, pText, dText);
   bp.setCenter(h);
   v.getChildren().add(update);
   Scene s = new Scene(bp, 250, 300);

   update.setOnAction(e2 -> {
    String fName = fText.getText(), lName = lText.getText(), e = eText.getText(), p = pText.getText(),
      d = dText.getText();
    member.setFirstName(fName);
    member.setLastName(lName);
    member.setEmail(e);
    member.setPhone(p);
    member.setDescription(d);
    ViewAccountScene.displayName.setText(fName + " " + lName);
    ViewAccountScene.displayDescription.setText(d);
    ViewAccountScene.displayEmail.setText(e);
    ViewAccountScene.displayPhone.setText(p);
    System.out.println(member.toString());
    for (AccountMember m : AccountsFile.AccountMembers)
     try {
      bw.write(m.toString());
      bw.newLine();
     } catch (IOException e1) {
      e1.printStackTrace();
     }
    try {
     bw.flush();
    } catch (IOException e1) {
     e1.printStackTrace();
    }
    try {
     AccountsFile.createNewFile(member);
    } catch (IOException e1) {
     e1.printStackTrace();
    }
    editWin.close();
   });

   editWin.setScene(s);
   editWin.showAndWait();

  }

  if (event.getSource() == addButton) {

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
   codeBox.getItems().addAll("MAF654845", "KTO987856", "HJT12478555");
   codeBox.setEditable(true);

   ComboBox<String> typeBox = new ComboBox<String>();
   typeBox.getItems().addAll("Card", "Cash", "Check");
   typeBox.setEditable(true);

   ComboBox<String> dwBox = new ComboBox<String>();
   dwBox.getItems().addAll("Withdrawl", "Deposit");
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

    {

     tran = new Transaction(

       localDate, codeBox.getSelectionModel().getSelectedItem().toString(), amount.getText(),
       typeBox.getSelectionModel().getSelectedItem().toString(), dwBox.getSelectionModel().getSelectedItem().toString()

     );

     member.history.add(tran);
    }
    if (dwBox.getSelectionModel().getSelectedItem() == "Deposit") {

     ViewAccountScene.labelTotal.setText("Total: " + member.getTotal());

     try {
      AccountsFile.deposit(member, tran);
     } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
     }

    } else {

     ViewAccountScene.labelTotal.setText("Total: " + member.getTotal());

     try {
      AccountsFile.withdraw(member, tran);
     } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
     }

    }

    popupwindow.close();

   }

   );

   popupwindow.setScene(scene);
   popupwindow.showAndWait();

  }

 }

}
