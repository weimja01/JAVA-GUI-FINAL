import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    // Enum for transaction type
    public enum TransactionType {
        INCOME, EXPENSE
    }
    
    private double amount;
    private String description;
    private LocalDate transactionDate;
    private Category category;
    private TransactionType transactionType;
    
    // Constructor
    public Transaction(double amount, String description, LocalDate transactionDate, 
                      Category category, TransactionType transactionType) {
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
        this.category = category;
        this.transactionType = transactionType;
    }
    
    // Getters
    public double getAmount() {
        return amount;
    }
    
    public String getDescription() {
        return description;
    }
    
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public TransactionType getTransactionType() {
        return transactionType;
    }
    
    // Setters
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    
    // toString for easy printing
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String sign = (transactionType == TransactionType.INCOME) ? "+" : "-";
        return transactionDate.format(formatter) + " | " + description + " | " + 
               category.getCategoryName() + " | " + sign + "$" + 
               String.format("%.2f", amount) + " | " + transactionType;
    }
}