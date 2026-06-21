import model.Product;
import service.InventoryService;

/**
  Demonstrates the Inventory Management System.
  Showcases add, update, delete operations and edge case handling.
 */
public class Main {

    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();

        // --- Add Products ---
        System.out.println("=== Adding Products ===");
        inventory.addProduct(new Product(101, "Laptop", 50, 75000.00));
        inventory.addProduct(new Product(102, "Mouse", 200, 500.00));
        inventory.addProduct(new Product(103, "Keyboard", 120, 1500.00));
        inventory.addProduct(new Product(104, "Monitor", 30, 22000.00));

        // Attempt to add a duplicate
        inventory.addProduct(new Product(101, "Duplicate Laptop", 5, 50000.00));

        System.out.println("\n=== Current Inventory ===");
        inventory.displayAll();

        // --- Update a Product ---
        System.out.println("\n=== Updating Product 102 (Mouse -> Wireless Mouse) ===");
        inventory.updateProduct(102, "Wireless Mouse", 180, 800.00);

        System.out.println("\n=== Inventory After Update ===");
        inventory.displayAll();

        // --- Delete a Product ---
        System.out.println("\n=== Deleting Product 103 (Keyboard) ===");
        inventory.deleteProduct(103);

        System.out.println("\n=== Inventory After Deletion ===");
        inventory.displayAll();

        // --- Edge Cases ---
        System.out.println("\n=== Edge Case: Update Non-existent Product ===");
        inventory.updateProduct(999, "Ghost Product", 0, 0.0);

        System.out.println("\n=== Edge Case: Delete Non-existent Product ===");
        inventory.deleteProduct(999);
    }
}
