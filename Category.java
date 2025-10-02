import java.awt.Color;

public class Category {
    private String categoryName;
    private double monthlyBudgetLimit;
    private Color displayColor;
    
    // Constructor
    public Category(String categoryName, double monthlyBudgetLimit, Color displayColor) {
        this.categoryName = categoryName;
        this.monthlyBudgetLimit = monthlyBudgetLimit;
        this.displayColor = displayColor;
    }
    
    // Getters
    public String getCategoryName() {
        return categoryName;
    }
    
    public double getMonthlyBudgetLimit() {
        return monthlyBudgetLimit;
    }
    
    public Color getDisplayColor() {
        return displayColor;
    }
    
    // Setters
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public void setMonthlyBudgetLimit(double monthlyBudgetLimit) {
        this.monthlyBudgetLimit = monthlyBudgetLimit;
    }
    
    public void setDisplayColor(Color displayColor) {
        this.displayColor = displayColor;
    }
    
    // toString for easy printing
    @Override
    public String toString() {
        return categoryName + " (Budget: $" + monthlyBudgetLimit + ")";
    }
    
    // equals method for comparing categories
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Category category = (Category) obj;
        return categoryName.equals(category.categoryName);
    }
}