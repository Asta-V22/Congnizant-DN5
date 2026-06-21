# Exercise 02 — E-Commerce Platform Search Function

## Problem Statement

Optimize the search functionality of an e-commerce platform to handle fast product
lookups. Compare linear and binary search algorithms to determine the best approach
for different scenarios.

## Approach

### Big O Notation

Big O notation describes the **upper bound** of an algorithm's growth rate as input
size increases, ignoring constants and lower-order terms:

| Notation | Name | Example |
|----------|------|---------|
| O(1) | Constant | HashMap lookup |
| O(log n) | Logarithmic | Binary search |
| O(n) | Linear | Linear search |
| O(n log n) | Linearithmic | Merge sort |
| O(n²) | Quadratic | Bubble sort |

### Search Algorithms Compared

**Linear Search** — scans every element sequentially.
- Works on **unsorted** data.
- Simple to implement.
- Becomes slow as dataset grows.

**Binary Search** — repeatedly halves the search space.
- Requires **sorted** data.
- Dramatically faster for large datasets.
- Sorting cost (O(n log n)) is a one-time overhead if data doesn't change often.

### Best / Average / Worst Case Scenarios

| Scenario | Linear Search | Binary Search |
|----------|--------------|---------------|
| **Best** | O(1) — first element | O(1) — middle element |
| **Average** | O(n/2) ≈ O(n) | O(log n) |
| **Worst** | O(n) — last or absent | O(log n) — absent |

## Data Structures Used

- **Array** — contiguous memory block providing O(1) index access for binary search midpoint calculation.

## Algorithm Used

- **Linear Search** — sequential scan through all elements.
- **Binary Search** — divide-and-conquer on sorted array.

## Project Structure

```
exercise-02-ecommerce-search/
├── README.md
├── analysis.md
├── src/
│   ├── model/
│   │   └── Product.java
│   ├── service/
│   │   └── SearchService.java
│   └── Main.java
└── sample-output.txt
```

## How to Run

```bash
cd src
javac model/*.java service/*.java Main.java
java Main
```
