
public class AccountHolder extends AccountMember {
 String passWord, userName;

 public AccountHolder(String firstName, String lastName, String email, String phone, String description,
   String passWord, String userName) {
  super(firstName, lastName, email, phone, description);
  this.passWord = passWord;
  this.userName = userName;
 }

}
