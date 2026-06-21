import model.Order;
import service.SortingService;

/**
 * Demonstrates Bubble Sort vs Quick Sort on customer orders.
 * Orders are sorted by total price for prioritization.
 */
public class Main {

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1001, "Alice",   4500.00),
            new Order(1002, "Bob",     1200.00),
            new Order(1003, "Charlie", 8900.00),
            new Order(1004, "Diana",    350.00),
            new Order(1005, "Eve",     6700.00),
            new Order(1006, "Frank",   2100.00)
        };

        SortingService sorter = new SortingService();

        // --- Original Order ---
        System.out.println("=== Original Orders ===");
        printOrders(orders);

        // --- Bubble Sort ---
        System.out.println("\n=== Sorted by Total Price (Bubble Sort) ===");
        Order[] bubbleSorted = sorter.bubbleSort(orders);
        printOrders(bubbleSorted);

        // --- Quick Sort ---
        System.out.println("\n=== Sorted by Total Price (Quick Sort) ===");
        Order[] quickSorted = sorter.quickSort(orders);
        printOrders(quickSorted);

        // --- Performance Comparison ---
        int n = orders.length;
        System.out.println("\n=== Performance Comparison ===");
        System.out.println("  Dataset size: " + n + " orders");
        System.out.println();
        System.out.println("  Bubble Sort:");
        System.out.println("    Best:    O(n)      — already sorted, with early termination");
        System.out.println("    Average: O(n^2)    — ~" + (n * n) + " comparisons");
        System.out.println("    Worst:   O(n^2)    — reverse sorted");
        System.out.println();
        System.out.println("  Quick Sort:");
        System.out.println("    Best:    O(n log n)");
        System.out.println("    Average: O(n log n) — ~"
                + (int)(n * Math.log(n) / Math.log(2)) + " comparisons");
        System.out.println("    Worst:   O(n^2)    — bad pivot selection");
        System.out.println();
        System.out.println("  Conclusion: Quick Sort is preferred for large datasets due to");
        System.out.println("  O(n log n) average performance and cache-friendly access patterns.");
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("  " + order);
        }
    }
}
