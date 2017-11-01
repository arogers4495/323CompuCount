import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class AccountMember {

 public String firstName, lastName, email, phone, description;
 protected File transactions;

 public String getLastName() {
  return lastName;
 }

 public static void createTransactionsFile() {
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

 public double total;

 public AccountMember(String firstName) {

  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.phone = phone;
  this.total = 0;

 }

 public void setFirstName(String name) {

  this.firstName = name;

 }

 public String getFirstName() {

  return this.firstName;

 }

 public double getTotal() {

  return total;
 }

}