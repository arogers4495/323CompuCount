import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;

public class Transaction {

 private SimpleStringProperty amount, type, WithdrawlDeposit, description, date;
 private double amountActual;

 Transaction(String date, String description, String amount, String type, String inOrOut) {
  amountActual = Double.parseDouble(amount);
  this.date = new SimpleStringProperty(date);
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
  return amountActual;
 }

 public void setAmount(String money) {
  amount.set(money);
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
}
