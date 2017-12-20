public class AccountHolder {

 private String fname, lname;
 private static String username;
 private static String password;

 public AccountHolder(String fname, String lname, String username, String password) {

  this.fname = fname;
  this.lname = lname;
  this.username = username;
  this.password = password;

 }

 public String getFname() {
  return fname;
 }

 public void setFname(String fname) {
  this.fname = fname;
 }

 public String getLname() {
  return lname;
 }

 public void setLname(String lname) {
  this.lname = lname;
 }

 public static String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public static String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public String toString() {
  return fname + "\t" + lname + "\t" + username + "\t" + password;
 }

}
