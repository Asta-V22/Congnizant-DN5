# Exercise 06 — Library Management System

## Problem Statement

Build a library management system that allows users to search for books by title.
Implement and compare linear search and binary search algorithms to understand
their performance trade-offs in different scenarios.

## Approach

### Search Algorithms Explained

**Linear Search**: Starts from the first element and checks each one sequentially
until the target is found or the list ends.
```
[A] [B] [C] [D] [E]  → Looking for "D"
 ✗   ✗   ✗   ✓       → Found at index 3 (4 comparisons)
```

**Binary Search**: Starts at the middle of a **sorted** list. If the target is
less than the middle, search the left half; otherwise, search the right half.
Repeat until found.
```
[A] [B] [C] [D] [E]  → Looking for "D" (sorted)
          ↑ mid="C"   → "D" > "C", search right half
              [D] [E]
               ↑ mid="D" → Found! (2 comparisons)
```

### Key Difference

| Aspect | Linear Search | Binary Search |
|--------|--------------|---------------|
| Prerequisite | None | **Sorted data** |
| Time Complexity | O(n) | O(log n) |
| Implementation | Simple loop | Divide-and-conquer |
| Best for | Small/unsorted data | Large/sorted data |

## Data Structures Used

- **ArrayList** — dynamic list for the unsorted catalog.
- **Array** — sorted copy for binary search.

## Algorithm Used

- **Linear Search** — O(n) sequential scan.
- **Binary Search** — O(log n) divide-and-conquer on sorted data.
- **Arrays.sort()** — O(n log n) to prepare data for binary search.

## Project Structure

```
exercise-06-library-management-system/
├── README.md
├── analysis.md
├── src/
│   ├── model/
│   │   └── Book.java
│   ├── service/
│   │   └── LibraryService.java
│   └── Main.java
└── sample-output.txt
```

## How to Run

```bash
cd src
javac model/*.java service/*.java Main.java
java Main
```
