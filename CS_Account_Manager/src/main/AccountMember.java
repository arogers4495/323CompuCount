
public class AccountMember {

 private String name;
 private double total;

 public AccountMember(String name) {

  this.name = name;
  this.total = 0;

 }

 public void setName(String name) {

  this.name = name;

 }

 public String getName() {

  return this.name;

 }

 public double getTotal() {

  return total;
 }

}