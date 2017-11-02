import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccountsFile {
 private ArrayList<AccountMember> AccountMembers;
 private BufferedWriter writer;
 private File mainFile;

 public AccountsFile() throws IOException {
  mainFile = new File("./Members");
  FileWriter fileWriter = new FileWriter(mainFile.getAbsolutePath(), true);
  // read in .txt file with all members, then populate the
  // AccountsFile.AccountMembers with that data
  writer = new BufferedWriter(fileWriter);
  AccountMembers = new ArrayList<AccountMember>();
 }

 public void addToArrayList(AccountMember member) {
  AccountMembers.add(member);
 }

 public void addMember(AccountMember name) throws IOException {
  writer.write(name.firstName);
  writer.newLine();
  writer.flush();
  addToArrayList(name);
 }

 public static void main(String[] args) throws IOException {
  AccountsFile newFile = new AccountsFile();
  for (AccountMember m : newFile.AccountMembers) {
   System.out.println(m.firstName);
  }
 }
}
