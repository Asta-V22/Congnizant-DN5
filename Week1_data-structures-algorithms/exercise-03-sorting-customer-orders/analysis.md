# Exercise 03 — Sorting Customer Orders: Analysis

## Time Complexity

| Algorithm | Best | Average | Worst |
|-----------|------|---------|-------|
| **Bubble Sort** | O(n) | O(n²) | O(n²) |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) |

### Scaling Comparison

| n (orders) | Bubble Sort (n²) | Quick Sort (n log n) | Speedup |
|------------|------------------|---------------------|---------|
| 10 | 100 | ~33 | 3x |
| 100 | 10,000 | ~664 | 15x |
| 1,000 | 1,000,000 | ~9,966 | 100x |
| 10,000 | 100,000,000 | ~132,877 | 752x |

Quick Sort's advantage grows dramatically with input size.

## Space Complexity

| Algorithm | Space |
|-----------|-------|
| Bubble Sort | O(1) — only a single temp variable for swapping |
| Quick Sort | O(log n) — recursion stack depth (average case) |

## Why Quick Sort is Generally Preferred

1. **Average-case performance**: O(n log n) vs O(n²) — Quick Sort is asymptotically
   faster for all but trivially small inputs.

2. **Cache efficiency**: Quick Sort accesses memory sequentially within partitions,
   making better use of CPU caches than algorithms that jump around.

3. **In-place**: Unlike Merge Sort, Quick Sort doesn't require O(n) extra memory.

4. **Practical speed**: Despite O(n²) worst case, Quick Sort's constant factors are
   small. With randomized pivot selection, the worst case is extremely unlikely.

### When Bubble Sort Wins

- **Nearly sorted data**: With the early-termination optimization, Bubble Sort is O(n)
  on already-sorted or nearly-sorted data.
- **Very small arrays**: For n < 10, the overhead of Quick Sort's recursion makes
  Bubble Sort competitive. (Java's `Arrays.sort` uses insertion sort for n ≤ 47.)
- **Stability required**: Bubble Sort is stable; Quick Sort is not. If preserving
  relative order of equal elements matters, Bubble Sort wins.

## Optimization Discussion

### Bubble Sort Improvements
- **Early termination**: If no swaps occur in a pass, the array is sorted — break early.
  (Implemented in our solution.)
- **Cocktail Shaker Sort**: Alternates direction each pass to move "turtles" (small
  elements at the end) faster. Still O(n²) but faster in practice.

### Quick Sort Improvements
1. **Randomized pivot**: Instead of always picking the last element, pick a random
   element to avoid O(n²) on sorted input.
2. **Median-of-three**: Pick the median of first, middle, and last elements as pivot.
3. **Three-way partitioning (Dutch National Flag)**: Handles many duplicate keys
   efficiently by partitioning into <, =, > regions.
4. **Hybrid approach**: Switch to Insertion Sort for small sub-arrays (n ≤ 10-20).
   This is what Java's `Arrays.sort()` does internally.
