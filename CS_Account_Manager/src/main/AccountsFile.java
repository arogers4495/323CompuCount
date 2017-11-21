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

public class AccountsFile {
 private static ArrayList<AccountMember> AccountMembers;
 private static BufferedWriter writer;
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
    member.index = lineScan.nextInt();
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
  for (AccountMember m : AccountMembers)
   System.out.println(m.toString() + "\n");
 }

 private static void addToArrayList(AccountMember member) {
  AccountMembers.add(member);
 }

 private static void createNewFile(AccountMember member) throws IOException {
  File memberFile = new File("./" + member.lastName + "_" + member.firstName);
  // creates a file with the member's last and then first name
  if (memberFile.createNewFile()) {
   System.out.println("Successfully created a new file");
   FileWriter fileWriter = new FileWriter(memberFile.getAbsolutePath());
   BufferedWriter memberWriter = new BufferedWriter(fileWriter);
   memberWriter.write(member.firstName + "\t" + member.lastName + "\t" + member.email + "\t" + member.phone + "\t"
     + member.description + "\t" + member.total);
   memberWriter.close();
  }
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
  File memberFile = AccountMember.getMemberFile(member);
  File mainFile = new File("./Members");
  FileWriter w = null;
  member.total -= amount;
  w = new FileWriter(memberFile, true);
  LocalDate today = LocalDate.now();
  String updateMessage = date.format(today) + "\t" + money.format(amount) + " withdrawn from the account of "
    + member.firstName + " " + member.lastName;
  w.write(updateMessage);
  w.close();
  updateMemberFile(member, updateMessage);
 }

 public void deposit(AccountMember member, double amount) {
  member.total += amount;

 }

 public static void addMember(AccountMember member) throws IOException {
  boolean memberExists = false;
  for (AccountMember m : AccountMembers)
   if (m.equals(member))
    memberExists = true;
   else
    memberExists = false;
  if (memberExists = false) {
   member.index = AccountMembers.size();
   addToArrayList(member);
   createNewFile(member);
   writer.write(member.index + "\t" + member.firstName + "\t" + member.lastName + "\t" + member.email + "\t"
     + member.phone + "\t" + member.description + "\t" + member.total);
   writer.newLine();
   writer.flush();
  } else
   System.out.println("This account already exists.");
 }

 public static void main(String[] args) throws IOException {
  AccountsFile mainFile = new AccountsFile();
  addMember(new AccountMember("Auston", "Rogers", "A@l.com", "406-111-1111", "Description", 400));
  AccountMember m = mainFile.AccountMembers.get(0);
  withdraw(m, 10);
 }
}