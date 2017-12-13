
public class Account {

 private double total, fees;
 private int n;
 private AccountMember[] member;

 public Account() {

  total = 0;
  n = 0;
  fees = 0;
  member = new AccountMember[2];
 }

 public void AddMember(AccountMember member) {

  this.member[n] = member;
  n++;
 }

 public int NumOfMembers() {

  return n;

 }

 public double getTotalAmount() {

  for (int i = 0; i < n; i++) {

   total = total + member[i].getTotal();

  }
  return total;

 }

public AccountMember[] getMembersArray() {
    
    return member;
}

}
