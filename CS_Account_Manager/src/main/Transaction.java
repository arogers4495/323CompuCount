import java.time.LocalDate;
import java.text.NumberFormat;
import javafx.beans.property.SimpleStringProperty;

public class Transaction {

 private SimpleStringProperty amount, type, WithdrawlDeposit, description, date;
 private NumberFormat num = NumberFormat.getCurrencyInstance();

 Transaction(LocalDate localDate, String description, String amount, String type, String inOrOut) {
  localDate = LocalDate.now();
  this.date = new SimpleStringProperty(localDate.toString());
  this.description = new SimpleStringProperty(description);
  this.amount = new SimpleStringProperty(amount);
  this.type = new SimpleStringProperty(type);
  this.WithdrawlDeposit = new SimpleStringProperty(inOrOut);
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

 public double setAmount(String money) {
  amount.set(money);
  return Double.parseDouble(amount.get());

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

 public void setType(String type) {
  this.type.set(type);
 }

 public String toString() {
  return LocalDate.now() + "\t" + type.getValue() + "\t" + num.format(getAmount()) + "\t" + description.getValue();

 }
}
