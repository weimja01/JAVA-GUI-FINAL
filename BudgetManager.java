import java.util.ArrayList;
import java.time.LocalDate;
import java.time.YearMonth;

public class BudgetManager {
    private ArrayList<Transaction> transactions;
    private ArrayList<Category> categories;
    private double currentBalance;
    private String fileName;
    
    // Constructor
    public BudgetManager() {
        this.transactions = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.currentBalance = 0.0;
        this.fileName = "budget_data.txt";
    }
    
    // Add a transaction
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        
        // Update balance based on transaction type
        if (transaction.getTransactionType() == Transaction.TransactionType.INCOME) {
            currentBalance += transaction.getAmount();
        } else {
            currentBalance -= transaction.getAmount();
        }
        
        System.out.println("Transaction added: " + transaction);
    }
    
    // Remove a transaction
    public void removeTransaction(Transaction transaction) {
        if (transactions.remove(transaction)) {
            // Adjust balance
            if (transaction.getTransactionType() == Transaction.TransactionType.INCOME) {
                currentBalance -= transaction.getAmount();
            } else {
                currentBalance += transaction.getAmount();
            }
            System.out.println("Transaction removed.");
        } else {
            System.out.println("Transaction not found.");
        }
    }
    
    // Add a category
    public void addCategory(Category category) {
        if (!categories.contains(category)) {
            categories.add(category);
            System.out.println("Category added: " + category);
        } else {
            System.out.println("Category already exists.");
        }
    }
    
    // Remove a category
    public void removeCategory(Category category) {
        if (categories.remove(category)) {
            System.out.println("Category removed: " + category.getCategoryName());
        } else {
            System.out.println("Category not found.");
        }
    }
    
    // Calculate current balance
    public double calculateBalance() {
        currentBalance = 0.0;
        for (Transaction t : transactions) {
            if (t.getTransactionType() == Transaction.TransactionType.INCOME) {
                currentBalance += t.getAmount();
            } else {
                currentBalance -= t.getAmount();
            }
        }
        return currentBalance;
    }
    
    // Get transactions by category
    public ArrayList<Transaction> getTransactionsByCategory(Category category) {
        ArrayList<Transaction> filtered = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getCategory().equals(category)) {
                filtered.add(t);
            }
        }
        return filtered;
    }
    
    // Get monthly spending for a specific category
    public double getMonthlySpending(Category category) {
        double total = 0.0;
        YearMonth currentMonth = YearMonth.now();
        
        for (Transaction t : transactions) {
            YearMonth transactionMonth = YearMonth.from(t.getTransactionDate());
            if (t.getCategory().equals(category) && 
                t.getTransactionType() == Transaction.TransactionType.EXPENSE &&
                transactionMonth.equals(currentMonth)) {
                total += t.getAmount();
            }
        }
        return total;
    }
    
    // Getters
    public ArrayList<Category> getCategories() {
        return categories;
    }
    
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    
    public double getCurrentBalance() {
        return currentBalance;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    // Setters
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    // Display all transactions
    public void displayAllTransactions() {
        System.out.println("\n===== ALL TRANSACTIONS =====");
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
        System.out.println("============================\n");
    }
    
    // Display budget summary
    public void displayBudgetSummary() {
        System.out.println("\n===== BUDGET SUMMARY =====");
        System.out.println("Current Balance: $" + String.format("%.2f", currentBalance));
        System.out.println("\nMonthly Spending by Category:");
        
        for (Category cat : categories) {
            double spent = getMonthlySpending(cat);
            double limit = cat.getMonthlyBudgetLimit();
            double percentage = (limit > 0) ? (spent / limit) * 100 : 0;
            
            System.out.printf("%s: $%.2f / $%.2f (%.1f%%)\n", 
                            cat.getCategoryName(), spent, limit, percentage);
        }
        System.out.println("==========================\n");
    }
    
    // Placeholder methods for file I/O (to be implemented later)
    public void saveToFile(String filename) {
        System.out.println("Save functionality will be implemented with GUI.");
    }
    
    public void loadFromFile(String filename) {
        System.out.println("Load functionality will be implemented with GUI.");
    }
}