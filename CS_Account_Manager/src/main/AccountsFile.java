import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//Testing
public class AccountsFile {
 private ArrayList<AccountMember> AccountMembers;
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
  date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
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
    member.total = lineScan.nextDouble();
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
  memberWriter.write(member.firstName + "\t" + member.lastName + "\t" + member.email + "\t" + member.phone + "\t"
    + member.description + "\t" + member.total);
  memberWriter.close();

 }

 private static void updateMemberFile(AccountMember member, String newText) throws IOException {
  File memberFile = new File("./" + member.lastName + "_" + member.firstName);
  FileWriter fileWriter = new FileWriter(memberFile.getAbsolutePath(), true);
  BufferedWriter memberWriter = new BufferedWriter(fileWriter);
  memberWriter.newLine();
  memberWriter.write(newText);
  memberWriter.flush();
  memberWriter.close();
 }

 // Update the account transactions file with withdrawals and deposits

 public static void withdraw(AccountMember member, double amount) throws IOException {
  member.total -= amount;
  double localTotal = 0;
  LocalDate today = LocalDate.now();
  String updateMessage = date.format(today) + "\t" + money.format(amount) + " withdrawn from the account of "
    + member.firstName + " " + member.lastName;
  updateMemberFile(member, updateMessage);
  Scanner memberScan = new Scanner(new File("./" + member.lastName + "_" + member.firstName)).useDelimiter("\t");
  while (!memberScan.next().equals(Double.class))
   localTotal = memberScan.nextDouble();
  System.out.println(localTotal);
 }

 public void deposit(AccountMember member, double amount) {
  member.total += amount;

 }

 public void addMember(AccountMember member) throws IOException {
  addToArrayList(member);
  createNewFile(member);
  writer.write(member.firstName + "\t" + member.lastName + "\t" + member.email + "\t" + member.phone + "\t"
    + member.description + "\t" + member.total);
  writer.newLine();
  writer.flush();
 }

 public static void main(String[] args) throws IOException {
  AccountsFile mainFile = new AccountsFile();
  // mainFile.addMember(new AccountMember("Auston", "Rogers", "A@l.com",
  // "406-111-1111", "Description", 400));
  withdraw(mainFile.AccountMembers.get(0), 0);

 }
}
