import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccountsFile {
 public ArrayList<AccountMember> AccountMembers;
 public BufferedWriter writer;
 public File mainFile;

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

 public void addMember(String member) throws IOException {

  writer.write(member);
  writer.newLine();
  writer.flush();
 }

 public static void main(String[] args) throws IOException {
 }
}
