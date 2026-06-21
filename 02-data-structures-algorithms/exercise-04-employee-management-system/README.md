# Exercise 04 — Employee Management System

## Problem Statement

Build an employee management system using **arrays** to store and manage employee records.
Demonstrate the core array operations (add, search, traverse, delete) and understand
their performance characteristics and limitations.

## Approach

### How Arrays are Represented in Memory

Arrays store elements in **contiguous (adjacent) memory locations**:

```
Index:   [0]      [1]      [2]      [3]      [4]
Memory:  |  Emp1  |  Emp2  |  Emp3  |  Emp4  |  null  |
Address: 0x100    0x108    0x110    0x118    0x120
```

**Advantages of contiguous storage:**
- **O(1) index access**: `array[i]` = base_address + (i × element_size).
- **Cache-friendly**: Adjacent elements are loaded into CPU cache together.
- **Predictable memory**: No per-element pointers or node overhead.

**Disadvantages:**
- **Fixed size**: Cannot grow beyond initial capacity without creating a new array.
- **Costly deletion**: Removing from the middle requires shifting all subsequent elements.
- **Costly insertion**: Inserting in the middle requires shifting elements to make room.

### Why Array for This Exercise

This exercise deliberately uses a raw array (not `ArrayList`) to demonstrate:
1. How fixed-size containers work at a low level.
2. The cost of element shifting during deletion.
3. Why dynamic data structures (ArrayList, LinkedList) were invented.

## Data Structures Used

- **Array** — fixed-size, contiguous-memory storage for Employee objects.

## Algorithm Used

- **Linear Search** — sequential scan for search and delete operations.
- **Element Shifting** — left-shift to fill gaps after deletion.

## Project Structure

```
exercise-04-employee-management-system/
├── README.md
├── analysis.md
├── src/
│   ├── model/
│   │   └── Employee.java
│   ├── service/
│   │   └── EmployeeService.java
│   └── Main.java
└── sample-output.txt
```

## How to Run

```bash
cd src
javac model/*.java service/*.java Main.java
java Main
```
