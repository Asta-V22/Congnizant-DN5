public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = new Product(101, "Laptop", 20, 55000);
        Product p2 = new Product(102, "Mouse", 100, 500);
        Product p3 = new Product(103, "Keyboard", 50, 1200);

        // Add Products
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        System.out.println("\nInventory:");
        inventory.displayInventory();

        // Update Product
        inventory.updateProduct(102, "Wireless Mouse", 80, 700);

        System.out.println("\nAfter Update:");
        inventory.displayInventory();

        // Delete Product
        inventory.deleteProduct(103);

        System.out.println("\nAfter Deletion:");
        inventory.displayInventory();
    }
}