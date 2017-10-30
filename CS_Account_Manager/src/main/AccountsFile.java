import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccountsFile {
 BufferedWriter writer;
 File mainFile;
 public ArrayList<AccountMember> AccountMembers;

 public AccountsFile() throws IOException {
  mainFile = new File("./Members");
  // read in .txt file with all members, then populate the
  // AccountsFile.AccountMembers with that data
  writer = new BufferedWriter(new FileWriter("./Members"));
  AccountMembers = new ArrayList<AccountMember>();
  this.initializeFile();
 }

 public void addToArrayList(AccountMember member) {
  AccountMembers.add(member);
 }

 public void addMember(String member) throws IOException {
  writer = new BufferedWriter(new FileWriter(mainFile, true));
  writer.append("");
  writer.append(member);
  writer.close();
 }

 public void initializeFile() throws IOException {
  String str = "Members";
  BufferedWriter writer = new BufferedWriter(new FileWriter(mainFile));
  writer.write(str);
  writer.close();
 }

 public static void main(String[] args) throws IOException {
  AccountsFile newFile = new AccountsFile();
  newFile.initializeFile();
  newFile.addMember("Auston");
 }
}
