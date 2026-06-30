# Exercise 02 — E-Commerce Search: Analysis

## Time Complexity Comparison

| Algorithm | Best Case | Average Case | Worst Case |
|-----------|-----------|-------------|------------|
| **Linear Search** | O(1) | O(n) | O(n) |
| **Binary Search** | O(1) | O(log n) | O(log n) |

### Scaling Comparison

| Dataset Size (n) | Linear (worst) | Binary (worst) | Speedup |
|-------------------|---------------|----------------|---------|
| 10 | 10 | 4 | 2.5x |
| 100 | 100 | 7 | 14x |
| 1,000 | 1,000 | 10 | 100x |
| 1,000,000 | 1,000,000 | 20 | 50,000x |

Binary search's logarithmic growth makes it dramatically superior for large datasets.

## Space Complexity

| Algorithm | Space |
|-----------|-------|
| Linear Search | O(1) — no extra memory |
| Binary Search | O(1) — iterative implementation uses constant extra space |

## Which Algorithm is More Suitable?

### Use Linear Search when:
- The dataset is **small** (< 50 elements).
- Data is **unsorted** and sorting cost isn't justified.
- Data changes **frequently** — sorting before every search is expensive.
- You need to search by **partial match** or **multiple fields**.

### Use Binary Search when:
- The dataset is **large** (hundreds or thousands of products).
- Data is **already sorted** or changes infrequently.
- **Multiple searches** will be performed on the same data, amortizing the O(n log n) sort cost.

### Recommendation for an E-Commerce Platform:
Binary search is the better choice because:
1. Product catalogs are relatively stable (sorted once, searched many times).
2. Catalogs can be very large (thousands to millions of products).
3. Search performance directly impacts user experience and conversion rates.
4. In practice, a database index (B-tree) extends this concept further.

## Optimization Discussion

1. **HashMap for exact lookups** — If searching by exact product name or ID,
   a HashMap provides O(1) average lookup, beating both algorithms.

2. **Trie for prefix search** — For autocomplete/type-ahead features,
   a Trie data structure provides O(m) lookup where m = query length.

3. **Database indexing** — In production, search is backed by indexed databases
   (B-tree indexes) or search engines (Elasticsearch) that generalize binary search
   to disk-based, multi-field queries.
