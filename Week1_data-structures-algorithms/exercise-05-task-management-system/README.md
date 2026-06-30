# Exercise 05 — Task Management System

## Problem Statement

Build a task management system where tasks can be added, deleted, searched, and traversed
efficiently. Use a **singly linked list** to manage the dynamic collection of tasks.

## Approach

### Understanding Linked Lists

A linked list is a linear data structure where elements (nodes) are connected via
pointers, rather than stored contiguously in memory.

**Singly Linked List** — each node has data + a `next` pointer:
```
[Task A | next] --> [Task B | next] --> [Task C | null]
 ^head
```

**Doubly Linked List** — each node has `prev` + data + `next`:
```
null <-- [prev | Task A | next] <--> [prev | Task B | next] <--> [prev | Task C | next] --> null
          ^head                                                    ^tail
```

### Why Singly Linked List?

| Feature | Singly | Doubly |
|---------|--------|--------|
| Memory per node | 1 pointer | 2 pointers |
| Forward traversal | ✅ | ✅ |
| Backward traversal | ❌ | ✅ |
| Delete with predecessor | O(1) | O(1) |
| Delete by value | O(n) | O(n) |
| Complexity | Simpler | More complex |

For this task management system, we only need forward traversal, so a singly linked
list is sufficient and uses less memory.

## Data Structures Used

- **Singly Linked List** — dynamic, pointer-based linear structure.

## Algorithm Used

- **Linear Traversal** — for search, display, and deletion operations.

## Project Structure

```
exercise-05-task-management-system/
├── README.md
├── analysis.md
├── src/
│   ├── model/
│   │   └── Task.java
│   ├── service/
│   │   └── TaskLinkedList.java
│   └── Main.java
└── sample-output.txt
```

## How to Run

```bash
cd src
javac model/*.java service/*.java Main.java
java Main
```
