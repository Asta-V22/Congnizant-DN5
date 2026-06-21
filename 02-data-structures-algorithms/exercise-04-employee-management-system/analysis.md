# Exercise 04 — Employee Management System: Analysis

## Time Complexity

| Operation | Time Complexity | Explanation |
|-----------|----------------|-------------|
| **Add** | O(n) | O(1) to place at end, but O(n) to check for duplicate ID |
| **Search by ID** | O(n) | Linear scan through all elements |
| **Traverse** | O(n) | Visit every element once |
| **Delete** | O(n) | O(n) to find + O(n) to shift elements = O(n) |

### If duplicate check is removed from Add:

| Operation | Best | Average | Worst |
|-----------|------|---------|-------|
| Add (append) | O(1) | O(1) | O(1)* |
| Search | O(1) | O(n/2) | O(n) |
| Traverse | O(n) | O(n) | O(n) |
| Delete | O(1) | O(n) | O(n) |

*O(1) assumes the array is not full. If resizing is needed, it's O(n).

## Space Complexity

- **O(n)** where n = array capacity (not the number of stored elements).
- Unused slots waste memory — if capacity is 1000 but only 10 employees exist,
  990 slots are allocated but empty.

## Limitations of Arrays

1. **Fixed size**: Must declare capacity upfront. Over-allocating wastes memory;
   under-allocating requires creating a new, larger array and copying all elements.

2. **Costly middle operations**: Inserting/deleting from the middle requires shifting
   O(n) elements.

3. **No built-in dynamic resizing**: Unlike `ArrayList`, arrays don't grow automatically.

4. **Search is O(n)**: Without sorting or hashing, finding an element requires
   scanning the entire array.

## When to Use Arrays

| Use Arrays When... | Avoid Arrays When... |
|--------------------|---------------------|
| Size is known and fixed | Size changes frequently |
| Index-based access is primary | Frequent insertions/deletions in the middle |
| Memory efficiency is critical | Need dynamic resizing |
| Iterating over all elements | Need fast search by key (use HashMap) |

## Optimization Discussion

1. **Use ArrayList** for automatic resizing — internally uses an array but grows
   by 50% when full (amortized O(1) append).

2. **Use HashMap** for O(1) search — if search-by-ID is the dominant operation,
   a HashMap eliminates the O(n) linear scan.

3. **Keep array sorted** — enables binary search (O(log n)) for search operations,
   but insertion becomes O(n) due to maintaining sort order.

4. **Hybrid approach** — use an array for storage + a HashMap index for lookups.
   This gives O(1) search with O(n) traversal efficiency.
