# Exercise 07 — Financial Forecasting

## Problem Statement

Develop a financial forecasting tool that predicts future values based on past growth
rates. Implement the prediction using recursion and optimize it using memoization
and iteration.

## Approach

### Understanding Recursion

Recursion is a technique where a method calls itself to solve a smaller version of
the same problem. Every recursive solution has:

1. **Base case** — the simplest case that stops recursion.
2. **Recursive case** — breaks the problem into a smaller subproblem.

### Future Value Formula

```
FV = PV × (1 + growthRate) ^ periods
```

**Recursive definition:**
```
futureValue(PV, rate, 0) = PV                                    ← base case
futureValue(PV, rate, n) = futureValue(PV, rate, n-1) × (1+rate) ← recursive case
```

### Four Approaches Implemented

| # | Approach | Time | Space | Description |
|---|---------|------|-------|-------------|
| 1 | **Pure Recursion** | O(n) | O(n) | Simple, but risks stack overflow |
| 2 | **Memoized Recursion** | O(n) | O(n) | Caches results (useful for overlapping subproblems) |
| 3 | **Iterative** | O(n) | O(1) | Loop-based, stack-safe |
| 4 | **Direct Formula** | O(1) | O(1) | Uses Math.pow(), most efficient |

## Data Structures Used

- **HashMap** — cache for memoized recursion.

## Algorithm Used

- **Recursion** — self-referential method decomposing the problem.
- **Memoization** — top-down dynamic programming technique.
- **Iteration** — bottom-up computation eliminating recursion overhead.

## Project Structure

```
exercise-07-financial-forecasting/
├── README.md
├── analysis.md
├── src/
│   ├── service/
│   │   └── ForecastingService.java
│   └── Main.java
└── sample-output.txt
```

## How to Run

```bash
cd src
javac service/*.java Main.java
java Main
```
