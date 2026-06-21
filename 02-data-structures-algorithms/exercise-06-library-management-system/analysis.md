# Exercise 06 — Library Management System: Analysis

## Time Complexity

| Operation | Linear Search | Binary Search |
|-----------|--------------|---------------|
| **Best case** | O(1) — first element | O(1) — middle element |
| **Average case** | O(n/2) ≈ O(n) | O(log n) |
| **Worst case** | O(n) — last or absent | O(log n) — absent |
| **Sorting cost** | Not needed | O(n log n) — one-time |

### Impact of Dataset Size

| Books (n) | Linear (worst) | Binary (worst) | Sort cost (once) |
|-----------|---------------|----------------|-----------------|
| 10 | 10 | 4 | ~33 |
| 100 | 100 | 7 | ~664 |
| 10,000 | 10,000 | 14 | ~132,877 |
| 1,000,000 | 1,000,000 | 20 | ~19,931,568 |

### Break-even Analysis

If you perform `k` searches on a dataset of `n` items:
- **Linear total cost**: k × n
- **Binary total cost**: n log n (sort once) + k × log n

Binary search becomes more efficient when:
```
k × n > n log n + k × log n
k > n log n / (n - log n)
k ≈ log n  (for large n)
```

For a library of 10,000 books, binary search pays off after just ~14 searches.

## Space Complexity

| Algorithm | Space |
|-----------|-------|
| Linear Search | O(1) — searches in-place |
| Binary Search | O(1) — iterative implementation |
| Sorted copy | O(n) — duplicate array for sorting |

## When to Use Each Algorithm

### Linear Search is Better When:
1. **Small datasets** (n < 50) — the overhead of sorting isn't justified.
2. **Unsorted, frequently changing data** — if books are added/removed often,
   re-sorting before every search negates the binary search advantage.
3. **Single search** — if you only search once, sorting (O(n log n)) + binary search
   (O(log n)) is slower than a single linear scan (O(n)).
4. **Partial matching** — searching by substring or pattern (e.g., "books containing
   'war' in the title") cannot use standard binary search.

### Binary Search is Better When:
1. **Large, stable datasets** — a library catalog that changes infrequently.
2. **Repeated searches** — each search after sorting is O(log n) instead of O(n).
3. **Pre-sorted data** — if data arrives sorted (e.g., from a database ORDER BY),
   sorting cost is zero.

## Optimization Discussion

1. **Maintain sorted order on insert** — use insertion sort (O(n) per insert) to
   keep the list always sorted, avoiding the full O(n log n) re-sort.

2. **HashMap for exact match** — if searching by exact title, a HashMap gives O(1)
   lookup. Best for catalogs where titles are unique.

3. **Trie for prefix search** — for autocomplete ("find all books starting with 'The'"),
   a Trie provides O(m) lookup where m = prefix length.

4. **Full-text search engine** — for real library systems, use Elasticsearch or Apache
   Lucene for fuzzy matching, relevance ranking, and multi-field search.
