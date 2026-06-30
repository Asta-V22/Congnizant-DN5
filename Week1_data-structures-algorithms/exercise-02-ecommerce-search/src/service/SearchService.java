package service;

import model.Product;
import java.util.Arrays;

/**
 * Provides linear and binary search implementations for product lookup.
 *
 * Linear Search: Scans every element sequentially. Works on unsorted data.
 * Binary Search: Halves the search space each step. Requires sorted data.
 */
public class SearchService {

    /**
     * Linear Search — examines each element until a match is found.
     *
     * Best case:  O(1)   — target is the first element.
     * Average:    O(n/2) — target is somewhere in the middle.
     * Worst case: O(n)   — target is last or not present.
     *
     * @return the matching Product, or null if not found
     */
    public Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Binary Search — divides the sorted array in half at each step.
     * The array MUST be sorted by product name before calling this method.
     *
     * Best case:  O(1)     — target is the middle element.
     * Average:    O(log n) — halving narrows to target.
     * Worst case: O(log n) — target is at an extreme or absent.
     *
     * @return the matching Product, or null if not found
     */
    public Product binarySearch(Product[] sortedProducts, String targetName) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Avoids integer overflow
            int comparison = sortedProducts[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return sortedProducts[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    /**
     * Returns a copy of the array sorted by product name for binary search.
     */
    public Product[] sortByName(Product[] products) {
        Product[] sorted = Arrays.copyOf(products, products.length);
        Arrays.sort(sorted);  // Uses Product.compareTo (by name)
        return sorted;
    }
}
