import model.Product;
import service.SearchService;

/**
 * Demonstrates Linear Search vs Binary Search on an e-commerce product catalog.
 */
public class Main {

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop",        "Electronics"),
            new Product(102, "Headphones",    "Electronics"),
            new Product(103, "Desk Chair",    "Furniture"),
            new Product(104, "Running Shoes", "Footwear"),
            new Product(105, "Backpack",      "Accessories"),
            new Product(106, "Monitor",       "Electronics"),
            new Product(107, "Keyboard",      "Electronics"),
            new Product(108, "Water Bottle",  "Kitchen")
        };

        SearchService search = new SearchService();

        // --- Linear Search (works on unsorted data) ---
        System.out.println("=== Linear Search (Unsorted Array) ===");

        String target1 = "Running Shoes";
        System.out.println("  Searching for: '" + target1 + "'");
        Product result1 = search.linearSearch(products, target1);
        System.out.println("  Result: " + (result1 != null ? result1 : "Not found"));

        String target2 = "Tablet";
        System.out.println("\n  Searching for: '" + target2 + "'");
        Product result2 = search.linearSearch(products, target2);
        System.out.println("  Result: " + (result2 != null ? result2 : "Not found"));

        // --- Binary Search (requires sorted data) ---
        System.out.println("\n=== Binary Search (Sorted Array) ===");
        Product[] sorted = search.sortByName(products);

        System.out.println("  Sorted product order:");
        for (Product p : sorted) {
            System.out.println("    " + p);
        }

        String target3 = "Monitor";
        System.out.println("\n  Searching for: '" + target3 + "'");
        Product result3 = search.binarySearch(sorted, target3);
        System.out.println("  Result: " + (result3 != null ? result3 : "Not found"));

        String target4 = "Tablet";
        System.out.println("\n  Searching for: '" + target4 + "'");
        Product result4 = search.binarySearch(sorted, target4);
        System.out.println("  Result: " + (result4 != null ? result4 : "Not found"));

        // --- Comparison Summary ---
        System.out.println("\n=== Performance Comparison ===");
        int n = products.length;
        System.out.println("  Dataset size: " + n + " products");
        System.out.println("  Linear Search: O(n)     -> worst case: " + n + " comparisons");
        System.out.println("  Binary Search: O(log n) -> worst case: "
                + (int) Math.ceil(Math.log(n) / Math.log(2)) + " comparisons");
        System.out.println("\n  Conclusion: Binary search is ~"
                + (n / (int) Math.ceil(Math.log(n) / Math.log(2)))
                + "x faster for this dataset,");
        System.out.println("  but requires the data to be sorted first (O(n log n) cost).");
    }
}
