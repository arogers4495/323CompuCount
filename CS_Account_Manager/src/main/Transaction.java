import java.time.LocalDate;
import java.text.NumberFormat;
import javafx.beans.property.SimpleStringProperty;

public class Transaction {

 private SimpleStringProperty amount, type, WithdrawlDeposit, description, date;
 private Double total, cardFee, uFee;

 Transaction(LocalDate localDate, String description, String amount, String type, String inOrOut) {
  localDate = LocalDate.now();
  this.date = new SimpleStringProperty(localDate.toString());
  this.description = new SimpleStringProperty(description);
  this.amount = new SimpleStringProperty(amount);
  this.type = new SimpleStringProperty(type);
  this.WithdrawlDeposit = new SimpleStringProperty(inOrOut);
  cardFee = 0.0;
  uFee = 0.0;        
 }

 public String getDate() {
  return date.get();
 }

 public void setDate(String date) {
  this.date.set(date);
 }

 public String getDescription() {
  return description.get();
 }

 public void setDescription(String fName) {
  description.set(fName);
 }

 public double getAmount() {
     
  return Double.parseDouble(amount.get());
  
 }

 public void setAmount(String money) {
     
     total = total + Double.parseDouble(money);
     
  amount = new SimpleStringProperty(Double.toString(total));
 }

 public String getWithdrawlDeposit() {
  return WithdrawlDeposit.get();

 }

 public void setWithdrawlDeposit(String inORout) {
  this.WithdrawlDeposit.set(inORout);

 }

 public String getType() {
  return type.get();
 }
 
 public double CardFee(){
     
     cardFee = Double.parseDouble(amount.get()) * 0.04;
     
    return cardFee;
     
 }
 
 public double UFee() {
     
     uFee = Double.parseDouble(amount.get()) * 0.08;
     
    return uFee;
     
 }

 public void setType(String type) {
  this.type.set(type);
 }

 public String toString() {
  return LocalDate.now() + "\t" + description.get() + "\t" + getAmount() + "\t" + type.getValue() + "\t"
    + WithdrawlDeposit.get();

 }
}
