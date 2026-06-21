# Exercise 01 — Inventory Management System: Analysis

## Time Complexity

| Operation | HashMap (Chosen) | ArrayList (Alternative) |
|-----------|-----------------|------------------------|
| Add | **O(1)** amortized | O(1) amortized (append) |
| Search by ID | **O(1)** average | O(n) linear scan |
| Update by ID | **O(1)** average | O(n) linear scan |
| Delete by ID | **O(1)** average | O(n) linear scan |
| Display All | O(n) | O(n) |

### Notes on HashMap Performance

- **Average case**: O(1) per operation — the hash function distributes keys uniformly
  across buckets, so each bucket holds very few entries.
- **Worst case**: O(n) if all keys hash to the same bucket (extreme collision).
  However, Java 8+ mitigates this by converting buckets from linked lists to balanced
  trees when a bucket exceeds 8 entries, improving worst case to **O(log n)**.
- **Amortized O(1) for add**: The HashMap resizes (rehashes all entries) when the
  load factor exceeds 0.75. This is an O(n) operation, but it happens infrequently
  enough that the amortized cost per insertion remains O(1).

## Space Complexity

- **O(n)** where n = number of products stored.
- HashMap overhead: approximately 48 bytes per entry (key wrapper, value reference,
  hash value, next/tree pointers).
- Total memory ≈ n × (sizeof(Product) + 48 bytes overhead).

## Optimization Discussion

### Current Optimizations

1. **Direct key access** — Using `productId` as the HashMap key eliminates sequential scanning.
2. **Duplicate check before insert** — Prevents silent overwrites of existing products.
3. **Immutable productId** — Declared `final` to prevent accidental key corruption.

### Possible Improvements

1. **Initial capacity tuning** — If the expected inventory size is known upfront,
   pre-size the HashMap to avoid rehashing:
   ```java
   new HashMap<>(expectedSize * 4 / 3 + 1);
   ```

2. **Thread safety** — For concurrent warehouse operations (multiple workers updating
   inventory simultaneously), replace `HashMap` with `ConcurrentHashMap`.

3. **Persistence** — In production, back the HashMap with a database (e.g., PostgreSQL)
   for durability across restarts.

4. **Search by name** — Current design only supports O(1) lookup by ID. To support
   name-based search, add a secondary index: `Map<String, Product>`.
