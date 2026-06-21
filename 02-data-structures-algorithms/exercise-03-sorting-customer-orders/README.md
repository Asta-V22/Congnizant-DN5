# Exercise 03 — Sorting Customer Orders

## Problem Statement

Sort customer orders by total price on an e-commerce platform to prioritize high-value
orders. Compare Bubble Sort and Quick Sort to understand their performance trade-offs.

## Approach

### Sorting Algorithms Overview

| Algorithm | Time (Best) | Time (Avg) | Time (Worst) | Space | Stable? |
|-----------|------------|-----------|-------------|-------|---------|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ Yes |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ Yes |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ No |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ Yes |

### Why These Two?

- **Bubble Sort** is the simplest sorting algorithm — ideal for teaching how sorting works.
- **Quick Sort** is the most widely used general-purpose sort — used internally by
  `Arrays.sort()` for primitive types in Java.

### How They Work

**Bubble Sort**: Repeatedly walks through the array, comparing adjacent pairs and
swapping them if out of order. After each pass, the largest unsorted element "bubbles"
to its correct position.

**Quick Sort**: Picks a pivot element, partitions the array into elements ≤ pivot
(left) and > pivot (right), then recursively sorts each partition.

## Data Structures Used

- **Array** — contiguous block of memory for in-place sorting.

## Algorithm Used

- **Bubble Sort** — O(n²) comparison-based sort with adjacent swaps.
- **Quick Sort** — O(n log n) divide-and-conquer sort with Lomuto partitioning.

## Project Structure

```
exercise-03-sorting-customer-orders/
├── README.md
├── analysis.md
├── src/
│   ├── model/
│   │   └── Order.java
│   ├── service/
│   │   └── SortingService.java
│   └── Main.java
└── sample-output.txt
```

## How to Run

```bash
cd src
javac model/*.java service/*.java Main.java
java Main
```
