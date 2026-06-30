package service;

import model.Product;
import java.util.HashMap;
import java.util.Map;

/**
 Manages warehouse inventory using a HashMap for O(1) average-case CRUD operations.
 
  Why HashMap?
  - Products are accessed by a unique productId (integer key).
  - HashMap provides O(1) average-case put, get, and remove.
  - Key uniqueness is enforced naturally by the map structure.
 **/
public class InventoryService {

    private final Map<Integer, Product> inventory = new HashMap<>();

    /**
      Adds a product to the inventory.
      Rejects duplicates based on productId.
      Time: O(1) average
     */
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("  ERROR: Product ID " + product.getProductId() + " already exists.");
            return;
        }
        inventory.put(product.getProductId(), product);
        System.out.println("  Added: " + product);
    }

    /**
      Updates an existing product's details.
      Time: O(1) average
     */
    public void updateProduct(int productId, String name, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("  ERROR: Product ID " + productId + " not found.");
            return;
        }
        product.setProductName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        System.out.println("  Updated: " + product);
    }

    /**
      Deletes a product by its ID.
      Time: O(1) average
     */
    public void deleteProduct(int productId) {
        Product removed = inventory.remove(productId);
        if (removed == null) {
            System.out.println("  ERROR: Product ID " + productId + " not found.");
            return;
        }
        System.out.println("  Deleted: " + removed);
    }

    /**
     * Displays all products in the inventory.
     * Time: O(n)
     */
    public void displayAll() {
        if (inventory.isEmpty()) {
            System.out.println("  Inventory is empty.");
            return;
        }
        for (Product product : inventory.values()) {
            System.out.println("  " + product);
        }
    }
}
