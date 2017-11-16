import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//Testing
public class AccountsFile {
 private static ArrayList<AccountMember> AccountMembers;
 private BufferedWriter writer;
 private FileWriter memberFileWriter;
 private File mainFile;
 public static NumberFormat money;
 public static DateTimeFormatter date;
 public static LocalDateTime now;

 public AccountsFile() throws IOException {
  mainFile = new File("./Members");
  FileWriter fileWriter = new FileWriter(mainFile.getAbsolutePath(), true);
  // read in .txt file with all members, then populate the
  // AccountsFile.AccountMembers with that data
  writer = new BufferedWriter(fileWriter);
  AccountMembers = new ArrayList<AccountMember>();
  Scanner mainFileScanner = new Scanner(mainFile);

  while (mainFileScanner.hasNextLine()) {
   AccountMember member = new AccountMember(null, null, null, null, null);
   String line = mainFileScanner.nextLine();
   Scanner lineScan = new Scanner(line).useDelimiter("\t");
   while (lineScan.hasNext()) {
    member.firstName = lineScan.next();
    member.lastName = lineScan.next();
    member.email = lineScan.next();
    member.phone = lineScan.next();
    member.description = lineScan.next();
    AccountMembers.add(member);
   }
  }
  money = NumberFormat.getCurrencyInstance();
  date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
 }

 private void addToArrayList(AccountMember member) {
  AccountMembers.add(member);
 }

 private void createNewFile(AccountMember member) throws IOException {
  File memberFile = new File("./" + member.lastName + "_" + member.firstName);
  // creates a file with the member's last and then first name
  if (memberFile.createNewFile()) {
   System.out.println("Successfully created a new file");
  }
  FileWriter fileWriter = new FileWriter(memberFile.getAbsolutePath());
  BufferedWriter memberWriter = new BufferedWriter(fileWriter);
  memberWriter.write(
    member.firstName + "\t" + member.lastName + "\t" + member.email + "\t" + member.phone + "\t" + member.description);
  memberWriter.close();

 }

 public void updateMemberFile(AccountMember member, String newText) throws IOException {
  File memberFile = new File("./" + member.lastName + "_" + member.firstName);
  FileWriter fileWriter = new FileWriter(memberFile.getAbsolutePath(), true);
  BufferedWriter memberWriter = new BufferedWriter(fileWriter);
  memberWriter.write(" " + newText);
  memberWriter.flush();
  memberWriter.close();
 }

 // Update the account transactions file with withdrawals and deposits

 public void withdraw(AccountMember member, double amount) throws IOException {
  member.total -= amount;
 }

 public void deposit(AccountMember member, double amount) {
  member.total += amount;
 }

 public void addMember(AccountMember member) throws IOException {
  addToArrayList(member);
  createNewFile(member);
  writer.write(
    member.firstName + "\t" + member.lastName + "\t" + member.email + "\t" + member.phone + "\t" + member.description);
  writer.newLine();
  writer.flush();
 }

 // Static method that will populate the ArrayList on startup

 public static void main(String[] args) throws IOException {
  AccountsFile mainFile = new AccountsFile();
  AccountMember member = new AccountMember("Auston", "Rogers", "@", "123-456-7890", "Description");
  for (AccountMember m : mainFile.AccountMembers)
   System.out.println(m.toString());
 }
}
