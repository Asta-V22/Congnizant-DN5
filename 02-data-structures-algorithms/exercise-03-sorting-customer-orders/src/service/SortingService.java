package service;

import model.Order;
import java.util.Arrays;

/**
 * Provides Bubble Sort and Quick Sort implementations for sorting orders by totalPrice.
 *
 * Both algorithms sort a COPY of the input array to preserve the original data.
 */
public class SortingService {

    /**
     * Bubble Sort — repeatedly steps through the list, compares adjacent elements,
     * and swaps them if they are in the wrong order.
     *
     * Characteristics:
     * - Simple to understand and implement.
     * - Stable sort (preserves relative order of equal elements).
     * - In-place (O(1) extra space).
     * - Early termination if no swaps occur (optimized for nearly sorted data).
     *
     * Time:  O(n^2) average/worst | O(n) best (already sorted)
     * Space: O(1)
     */
    public Order[] bubbleSort(Order[] orders) {
        Order[] arr = Arrays.copyOf(orders, orders.length);
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].getTotalPrice() > arr[j + 1].getTotalPrice()) {
                    // Swap adjacent elements
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps occurred, array is already sorted
            if (!swapped) break;
        }
        return arr;
    }

    /**
     * Quick Sort — selects a pivot element and partitions the array so that
     * elements smaller than the pivot go left, and larger go right.
     *
     * Characteristics:
     * - Divide-and-conquer strategy.
     * - Not stable (may change relative order of equal elements).
     * - In-place (O(log n) stack space for recursion).
     * - Very fast in practice due to cache-friendly memory access.
     *
     * Time:  O(n log n) average | O(n^2) worst (already sorted with bad pivot)
     * Space: O(log n) for recursion stack
     */
    public Order[] quickSort(Order[] orders) {
        Order[] arr = Arrays.copyOf(orders, orders.length);
        quickSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSortHelper(Order[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Lomuto partition scheme — uses the last element as pivot.
     * Elements <= pivot are moved to the left partition.
     */
    private int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in its correct position
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
