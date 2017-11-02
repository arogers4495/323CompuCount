import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

public class AccountsFile {
 private static ArrayList<AccountMember> AccountMembers;
 private BufferedWriter writer;
 private File mainFile;
 public static NumberFormat money;

 public AccountsFile() throws IOException {
  mainFile = new File("./Members");
  FileWriter fileWriter = new FileWriter(mainFile.getAbsolutePath(), true);
  // read in .txt file with all members, then populate the
  // AccountsFile.AccountMembers with that data
  writer = new BufferedWriter(fileWriter);
  AccountMembers = new ArrayList<AccountMember>();
  money = NumberFormat.getCurrencyInstance();
 }

 private void addToArrayList(AccountMember member) {
  AccountMembers.add(member);
 }

 private void createNewFile(AccountMember member) throws IOException {
  File memberFile = new File("./" + member.lastName + "_" + member.firstName);// creates a file with the member's last
                                                                              // and then first name
  if (memberFile.createNewFile()) {
   System.out.println("Successfully created a new file");
  }
  FileWriter fileWriter = new FileWriter(memberFile.getAbsolutePath());
  BufferedWriter memberWriter = new BufferedWriter(fileWriter);
  memberWriter.write(member.firstName + " " + member.lastName + "\tAccount Balance:\t" + money.format(member.total));
  memberWriter.close();

 }

 private void updateMemberFile(AccountMember member) throws IOException {
  File memberFile = new File("./" + member.lastName + "_" + member.firstName);
  FileWriter fileWriter = new FileWriter(memberFile.getAbsolutePath());
 }

 public void withdraw(AccountMember member, double amount) {
  member.total -= amount;
 }

 public void deposit(AccountMember member, double amount) {
  member.total += amount;
 }

 public void addMember(AccountMember member) throws IOException {
  addToArrayList(member);
  createNewFile(member);
  writer.write(member.firstName + " " + member.lastName + "\tAccount Balance:\t" + money.format(member.total));
  writer.newLine();
  writer.flush();
 }

 public static void main(String[] args) throws IOException {
 }
}
