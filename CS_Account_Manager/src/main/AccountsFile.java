import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class AccountsFile {
 private static ArrayList<AccountMember> AccountMembers;
 private static BufferedWriter writer;
 private FileWriter memberFileWriter;
 private static File mainFile;
 public static NumberFormat money;
 public static DateTimeFormatter date;
 public static LocalDate now;

 public AccountsFile() throws IOException {
  mainFile = new File("./Members");
  FileWriter fileWriter = new FileWriter(mainFile.getAbsolutePath(), true);
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
  money = new DecimalFormat("$,000.00");
  date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
 }

 private static void addToArrayList(AccountMember member) {
  AccountMembers.add(member);
 }

 private static void createNewFile(AccountMember member) throws IOException {
  File memberFile = new File("./" + member.lastName + "_" + member.firstName);
  // creates a file with the member's last and then first name
  if (memberFile.createNewFile()) {
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

 public static void withdraw(AccountMember member, Transaction t) throws IOException {
  File memberFile = AccountMember.getMemberFile(member);
  File transactionFile = new File("./" + member.lastName + "_" + member.firstName + "_" + "transactions");
  double amount = t.getAmount();
  member.total -= amount;
  member.history.add(t);

  FileWriter fW = new FileWriter(mainFile);
  FileWriter mW = new FileWriter(memberFile, true);
  FileWriter transactionWriter = new FileWriter(transactionFile, true);
  BufferedWriter mBW = new BufferedWriter(mW);
  BufferedWriter w = new BufferedWriter(fW);
  BufferedWriter tBW = new BufferedWriter(transactionWriter);

  for (AccountMember m : AccountMembers) {
   w.write(m.toString());
   w.newLine();
  }
  w.flush();
  LocalDate today = LocalDate.now();
  String updateMessage = date.format(today) + "\t" + money.format(amount) + " withdrawn from the account of "
    + member.firstName + " " + member.lastName + ";\t" + money.format(member.total) + " remaining";
  mBW.newLine();
  mBW.write(updateMessage);
  mBW.flush();
  tBW.write(t.toString());
  tBW.newLine();

  tBW.flush();
 }

 public static void deposit(AccountMember member, Transaction t) throws IOException {
  File memberFile = AccountMember.getMemberFile(member);

  File transactionFile = new File("./" + member.lastName + "_" + member.firstName + "_" + "transactions");
  double amount = t.getAmount();
  member.total += amount;
  member.history.add(t);

  FileWriter fW = new FileWriter(mainFile);
  FileWriter mW = new FileWriter(memberFile, true);
  FileWriter transactionWriter = new FileWriter(transactionFile, true);
  BufferedWriter mBW = new BufferedWriter(mW);
  BufferedWriter w = new BufferedWriter(fW);
  BufferedWriter tBW = new BufferedWriter(transactionWriter);

  for (AccountMember m : AccountMembers) {
   w.write(m.toString());
   w.newLine();
  }
  w.flush();
  LocalDate today = LocalDate.now();
  String updateMessage = date.format(today) + "\t" + money.format(amount) + " deposited into the account of "
    + member.firstName + " " + member.lastName + ";\t" + money.format(member.total) + " remaining";
  mBW.newLine();
  mBW.write(updateMessage);
  mBW.flush();
  tBW.write(t.toString());
  tBW.newLine();
  tBW.flush();
 }

 public static boolean addMember(AccountMember member) throws IOException {
  boolean memberExists = false;
  if (AccountMembers.contains(member))
   memberExists = true;
  else if (memberExists == false) {
   member.index = AccountMembers.size();
   addToArrayList(member);
   createNewFile(member);
   writer.write(member.toString());
   writer.newLine();
   writer.flush();
  } else
   System.out.println("This account already exists.");
  return memberExists;
 }

 public static void deleteMember(AccountMember member) {
  AccountMembers.remove(member);
  File memberFile = AccountMember.getMemberFile(member);
  memberFile.delete();
 }

 public ArrayList<AccountMember> getAccountMembers() {
  return AccountMembers;
 }

 public static void main(String[] args) throws IOException {
  AccountsFile mainFile = new AccountsFile();
  String x = "TEST";
  AccountMember Auston = new AccountMember("Auston", "Rogers", "auston.rogers@umconnect.umt.edu", "1-406-546-4781",
    "Student");
  Transaction t = new Transaction(LocalDate.now(), "Trial description", "1000000", "withdrawal", "out");
   AccountsFile.addMember(Auston);

  // I've added the bit of code below to demonstrate the mechanics of how my
  // deposit/withdraw functions work; since they are static, they only need to
  // call the AccountsFile class, not an instance of it.



 }
}