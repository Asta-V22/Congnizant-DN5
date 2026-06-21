# Exercise 07 — Financial Forecasting: Analysis

## Time Complexity

| Approach | Time | Space | Stack Overflow Risk |
|----------|------|-------|-------------------|
| **Pure Recursion** | O(n) | O(n) stack | Yes (n > ~10,000) |
| **Memoized Recursion** | O(n) | O(n) stack + O(n) cache | Yes |
| **Iterative** | O(n) | O(1) | No |
| **Direct Formula** | O(1) | O(1) | No |

### Why All Recursive Approaches are O(n) Here

The future value calculation is a **linear recursion** — each call makes exactly one
recursive call. There are no overlapping subproblems (unlike Fibonacci), so memoization
doesn't reduce the number of computations. It's included here to demonstrate the
technique, which is critical for problems like:

- **Fibonacci sequence**: `fib(n)` has O(2^n) without memoization → O(n) with memoization.
- **Knapsack problem**: Exponential without DP → polynomial with memoization.
- **Shortest paths**: Many graph algorithms use memoized recursion.

### Recursion Call Stack Example (periods=5)

```
futureValue(100000, 0.08, 5)
  └→ futureValue(100000, 0.08, 4) × 1.08
       └→ futureValue(100000, 0.08, 3) × 1.08
            └→ futureValue(100000, 0.08, 2) × 1.08
                 └→ futureValue(100000, 0.08, 1) × 1.08
                      └→ futureValue(100000, 0.08, 0) × 1.08
                           └→ return 100000  ← base case
```

Stack depth = n + 1 frames. For n = 100,000, this exceeds Java's default stack size
(~512KB), causing `StackOverflowError`.

## Optimization Discussion

### 1. Replace Recursion with Iteration (Done)
The iterative approach eliminates stack overflow risk entirely and uses O(1) space.
This is the recommended approach for production.

### 2. Use Direct Formula (Done)
`Math.pow()` computes the result in O(1) using hardware-optimized floating-point
exponentiation. Most efficient for single calculations.

### 3. Tail-Call Optimization (TCO)
Some languages (Scala, Kotlin) optimize tail-recursive calls to reuse the same stack
frame. Java does NOT support TCO, so recursion is always O(n) space in Java.

A tail-recursive version would look like:
```java
double futureValueTail(double currentValue, double rate, int remaining) {
    if (remaining == 0) return currentValue;
    return futureValueTail(currentValue * (1 + rate), rate, remaining - 1);
}
```
In languages with TCO, this would use O(1) stack space. In Java, it still uses O(n).

### 4. When Memoization Actually Helps

Consider a modified problem: "Calculate future values for ALL years from 1 to n."

Without memoization: Each `futureValue(PV, rate, k)` recomputes from scratch → O(n²) total.
With memoization: Each year's result is cached and reused → O(n) total.

```java
// Without memoization: O(n²)
for (int year = 1; year <= n; year++) {
    System.out.println(futureValueRecursive(pv, rate, year));  // O(year) each
}

// With memoization: O(n)
Map<Integer, Double> memo = new HashMap<>();
for (int year = 1; year <= n; year++) {
    System.out.println(futureValueMemoized(pv, rate, year, memo));  // O(1) after first
}
```

This is where memoization provides a genuine speedup.
