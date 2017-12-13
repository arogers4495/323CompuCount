import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccountMember {

 public String firstName, lastName, email, phone, description;
 protected File transactions, memberFile;
 protected ArrayList<Transaction> history;
 public double total;
 public int index;

 public String getLastName() {
  return lastName;
 }

 public static File getMemberFile(AccountMember member) {
  File memberFile = new File("./Directory/Members/" + member.lastName + "_" + member.firstName + ".txt");
  return memberFile;
 }

 public static File getTransactionFile(AccountMember member) {
  File memberFile = new File(
    "./Directory/Transactions/" + member.lastName + "_" + member.firstName + "_transactions.txt");
  return memberFile;
 }

 public void createTransactionsFile() throws IOException {
  File memberFile = new File("./Directory/Transactions/" + lastName + "_" + firstName + "_transactions.txt");
  FileWriter memberFileWriter = new FileWriter(memberFile);
  BufferedWriter memberBufferedFileWriter = new BufferedWriter(memberFileWriter);
  for (Transaction t : history) {
   memberBufferedFileWriter.write(t.getAmount() + " " + t.getDate() + " " + t.getType());
   memberBufferedFileWriter.newLine();
  }
  memberBufferedFileWriter.flush();
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getPhone() {
  return phone;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public AccountMember(String firstName, String lastName, String email, String phone, String description) {
  history = new ArrayList<Transaction>();
  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.phone = phone;
  this.description = description;
  this.total = 0;
  transactions = new File("./Directory/Transactions/" + lastName + "_" + firstName + "_transactions.txt");

 }

 // second constructor allows account to be instantiated with an amount already
 // in it
 public AccountMember(String firstName, String lastName, String email, String phone, String description, double total) {
  history = new ArrayList<Transaction>();
  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.phone = phone;
  this.description = description;
  this.total = total;
  transactions = new File("./Directory/Transactions/" + lastName + "_" + firstName + "_transactions.txt");
 }

 public void setFirstName(String name) {

  this.firstName = name;

 }

 public String getFirstName() {

  return this.firstName;

 }
 
 public String getName() {
     
     return firstName + " " + lastName;
     
 }

 public double getTotal() {

  return total;
 }

 public String toString() {
  return index + "\t" + firstName + "\t" + lastName + "\t" + email + "\t" + phone + "\t" + description + "\t" + total;
 }

 public boolean equals(AccountMember member) {
  if (firstName.equals(member.firstName) && lastName.equals(member.lastName) && email.equals(member.email)
    && phone.equals(member.phone) && description.equals(member.description))
   return true;
  else
   return false;

 }
}