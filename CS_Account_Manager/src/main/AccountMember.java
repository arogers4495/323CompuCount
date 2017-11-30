import java.io.File;

public class AccountMember {

 public String firstName, lastName, email, phone, description;
 protected File transactions;
 public double total;
 public int index;

 public String getLastName() {
  return lastName;
 }

 public static File getMemberFile(AccountMember member) {
  File memberFile = new File("./" + member.lastName + "_" + member.firstName);
  return memberFile;
 }

 public static File createTransactionsFile(AccountMember member) {
  File memberFile = new File("./" + member.lastName + "_" + member.firstName + "_transactions");
  return memberFile;
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

  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.phone = phone;
  this.description = description;
  this.total = 0;

 }

 // second constructor allows account to be instantiated with an amount already
 // in it
 public AccountMember(String firstName, String lastName, String email, String phone, String description, double total) {

  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.phone = phone;
  this.description = description;
  this.total = total;

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