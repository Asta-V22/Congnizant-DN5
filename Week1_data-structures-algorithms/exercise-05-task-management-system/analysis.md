# Exercise 05 — Task Management System: Analysis

## Time Complexity

| Operation | Time Complexity | Explanation |
|-----------|----------------|-------------|
| **Add (at tail)** | O(n) | Must traverse to find the last node |
| **Add (at head)** | O(1) | Just update the head pointer |
| **Search by ID** | O(n) | Linear traversal in worst case |
| **Traverse** | O(n) | Visit every node once |
| **Delete by ID** | O(n) | Must find the node and its predecessor |

### With Tail Pointer Optimization

If we maintain a `tail` reference in addition to `head`:

| Operation | Without Tail | With Tail |
|-----------|-------------|-----------|
| Add at tail | O(n) | **O(1)** |
| Add at head | O(1) | O(1) |
| Delete tail | O(n) | O(n)* |

*Deleting the tail still requires O(n) in a singly linked list because we need
the predecessor. A doubly linked list would make this O(1).

## Space Complexity

- **O(n)** where n = number of tasks.
- Each node: Task object + 1 pointer (next reference) ≈ 8 bytes overhead per node.

## Linked Lists vs Arrays for Dynamic Data

| Criterion | Array | Linked List |
|-----------|-------|-------------|
| **Insert at beginning** | O(n) — shift all | **O(1)** — update head |
| **Insert at end** | O(1) amortized | O(n) or O(1) with tail |
| **Delete from middle** | O(n) — shift | O(n) find + **O(1)** relink |
| **Random access** | **O(1)** — index | O(n) — traverse |
| **Memory** | Contiguous block | Scattered nodes + pointer overhead |
| **Cache performance** | **Excellent** | Poor (nodes scattered in memory) |
| **Size flexibility** | Fixed (or costly resize) | **Grows/shrinks freely** |

### When to Use Linked Lists

✅ **Use linked lists when:**
- Frequent insertions/deletions at the beginning or middle.
- Size is unpredictable and changes frequently.
- No need for random access by index.

❌ **Avoid linked lists when:**
- Frequent random access is needed (use arrays).
- Dataset is small and fixed-size (arrays are simpler and cache-friendly).
- Memory is constrained (pointer overhead adds up).

## Optimization Discussion

1. **Tail pointer**: Maintain a `tail` reference to make tail insertion O(1).

2. **Doubly linked list**: If backward traversal or efficient tail deletion is needed,
   add `prev` pointers (at the cost of extra memory per node).

3. **Sentinel node**: Use a dummy head node to eliminate special-case handling for
   head insertion/deletion, simplifying the code.

4. **HashMap index**: For O(1) search, maintain a `Map<Integer, Node>` alongside
   the linked list. This uses extra memory but eliminates linear search.
