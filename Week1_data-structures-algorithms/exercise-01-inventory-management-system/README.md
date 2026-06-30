# Exercise 01 — Inventory Management System

## Problem Statement

Design an inventory management system for a warehouse that supports adding, updating,
and deleting products. The system must handle large inventories efficiently, making the
choice of data structure critical for performance.

## Approach

### Why Data Structures & Algorithms Matter Here

In a warehouse managing thousands of products:
- **Searching** for a product by ID must be fast to process orders in real-time.
- **Adding/Removing** products must not degrade as inventory scales.
- A poor choice (e.g., unsorted array) would require O(n) scans for every lookup,
  making operations sluggish at scale.

### Chosen Data Structure: `HashMap<Integer, Product>`

A `HashMap` maps each `productId` to its `Product` object. This provides:
- **O(1) average-case** lookups, insertions, and deletions.
- **Natural key uniqueness** — prevents duplicate product IDs.
- Ideal when access patterns are primarily by a unique identifier.

### Alternatives Considered

| Structure | Add | Search by ID | Delete | Verdict |
|-----------|-----|-------------|--------|---------|
| **HashMap** | O(1) | O(1) | O(1) | ✅ Best fit — constant-time operations |
| ArrayList | O(1) | O(n) | O(n) | ❌ Linear scan required |
| TreeMap | O(log n) | O(log n) | O(log n) | ⚠️ Overkill — sorted order not needed |

## Data Structures Used

- **HashMap** — Hash-based key-value store providing O(1) average-case CRUD operations.

## Algorithm Used

- **Hashing** — `productId.hashCode()` maps keys to bucket indices for direct access.

## Project Structure

```
exercise-01-inventory-management-system/
├── README.md
├── analysis.md
├── src/
│   ├── model/
│   │   └── Product.java
│   ├── service/
│   │   └── InventoryService.java
│   └── Main.java
└── sample-output.txt
```

