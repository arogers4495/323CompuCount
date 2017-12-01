import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;

public class Transaction {
    
    private SimpleStringProperty amount, type, WithdrawlDeposit , description, date;

    Transaction(LocalDate localDate, String description, String amount, String type, String inOrOut) {
        
        this.date = new SimpleStringProperty(localDate.toString());
        this.description = new SimpleStringProperty(description);
        this.amount = new SimpleStringProperty(amount);
        this.type = new SimpleStringProperty(type);
        this.WithdrawlDeposit = new SimpleStringProperty(inOrOut);
        
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String fName) {
        description.set(fName);
    }

    public double getAmount() {
        
        return Double.parseDouble(amount.get());
    }

    public void setAmount(String money) {
        amount.set(money);
    }

    public String getWithdrawlDeposit() {
        return WithdrawlDeposit.get();
    }

    public void setWithdrawlDeposit(String inORout) {
        this.WithdrawlDeposit.set(inORout);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }
}
