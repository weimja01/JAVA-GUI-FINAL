import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;

public class BudgetTrackerTest {
    public static void main(String[] args) {
        System.out.println("===== BUDGET TRACKER TEST =====\n");
        
        // Create BudgetManager
        BudgetManager manager = new BudgetManager();
        
        // Create categories
        System.out.println("Creating categories...");
        Category food = new Category("Food", 200.0, Color.ORANGE);
        Category transportation = new Category("Transportation", 150.0, Color.BLUE);
        Category entertainment = new Category("Entertainment", 100.0, Color.MAGENTA);
        Category income = new Category("Income", 0.0, Color.GREEN);
        
        // Add categories to manager
        manager.addCategory(food);
        manager.addCategory(transportation);
        manager.addCategory(entertainment);
        manager.addCategory(income);
        
        System.out.println("\n--- Creating Transactions ---\n");
        
        // Create some transactions
        Transaction t1 = new Transaction(
            1200.0, 
            "Part-time job payment", 
            LocalDate.now().minusDays(15),
            income,
            Transaction.TransactionType.INCOME
        );
        
        Transaction t2 = new Transaction(
            45.50,
            "Grocery shopping",
            LocalDate.now().minusDays(10),
            food,
            Transaction.TransactionType.EXPENSE
        );
        
        Transaction t3 = new Transaction(
            35.00,
            "Gas station",
            LocalDate.now().minusDays(8),
            transportation,
            Transaction.TransactionType.EXPENSE
        );
        
        Transaction t4 = new Transaction(
            15.75,
            "Coffee and lunch",
            LocalDate.now().minusDays(5),
            food,
            Transaction.TransactionType.EXPENSE
        );
        
        Transaction t5 = new Transaction(
            25.00,
            "Movie tickets",
            LocalDate.now().minusDays(3),
            entertainment,
            Transaction.TransactionType.EXPENSE
        );
        
        Transaction t6 = new Transaction(
            67.20,
            "Restaurant dinner",
            LocalDate.now().minusDays(1),
            food,
            Transaction.TransactionType.EXPENSE
        );
        
        Transaction t7 = new Transaction(
            500.0,
            "Freelance project",
            LocalDate.now(),
            income,
            Transaction.TransactionType.INCOME
        );
        
        // Add transactions to manager
        manager.addTransaction(t1);
        manager.addTransaction(t2);
        manager.addTransaction(t3);
        manager.addTransaction(t4);
        manager.addTransaction(t5);
        manager.addTransaction(t6);
        manager.addTransaction(t7);
        
        // Display all transactions
        manager.displayAllTransactions();
        
        // Display budget summary
        manager.displayBudgetSummary();
        
        // Test filtering by category
        System.out.println("--- Food Transactions ---");
        ArrayList<Transaction> foodTransactions = manager.getTransactionsByCategory(food);
        for (Transaction t : foodTransactions) {
            System.out.println(t);
        }
        
        // Test removing a transaction
        System.out.println("\n--- Removing a transaction ---");
        manager.removeTransaction(t5);
        
        // Display updated summary
        manager.displayBudgetSummary();
        
        // Test balance calculation
        System.out.println("Recalculated Balance: $" + 
                         String.format("%.2f", manager.calculateBalance()));
        
        System.out.println("\n===== TEST COMPLETE =====");
    }
}