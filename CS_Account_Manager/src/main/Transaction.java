import javafx.beans.property.SimpleStringProperty;

public class Transaction {

    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;

    Transaction(String Date, String description, String amount) {
        this.firstName = new SimpleStringProperty(Date);
        this.lastName = new SimpleStringProperty(description);
        this.email = new SimpleStringProperty(amount);
    }

    public String getDate() {
        return firstName.get();
    }

    public void setDate(String fName) {
        firstName.set(fName);
    }

    public String getDescription() {
        return lastName.get();
    }

    public void setDescription(String fName) {
        lastName.set(fName);
    }

    public String getAmount() {
        return email.get();
    }

    public void setAmount(String fName) {
        email.set(fName);
    }
}
