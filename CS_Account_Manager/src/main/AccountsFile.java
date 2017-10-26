import java.util.ArrayList;

public class AccountsFile {
 public ArrayList<AccountMember> AccountMembers;

 public AccountsFile() {
  AccountMembers = new ArrayList<AccountMember>();
 }

 public void addToArrayList(AccountMember member) {
  AccountMembers.add(member);
 }
}
