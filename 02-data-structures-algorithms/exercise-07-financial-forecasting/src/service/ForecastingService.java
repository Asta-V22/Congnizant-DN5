package service;

import java.util.HashMap;
import java.util.Map;

/**
 * Financial forecasting service that predicts future values based on past growth rates.
 *
 * Formula: FV = PV × (1 + growthRate) ^ periods
 *
 * Implements four approaches to demonstrate recursion, memoization, and iteration:
 * 1. Pure recursion    — simple but O(n) stack depth.
 * 2. Memoized recursion — caches intermediate results.
 * 3. Iteration         — no stack overhead, O(1) space.
 * 4. Direct formula    — O(1) using Math.pow().
 */
public class ForecastingService {

    /**
     * Approach 1: Pure Recursion
     *
     * Base case:  futureValue(PV, rate, 0) = PV
     * Recursive:  futureValue(PV, rate, n) = futureValue(PV, rate, n-1) × (1 + rate)
     *
     * Time:  O(n) — one recursive call per period.
     * Space: O(n) — call stack grows linearly with periods.
     *
     * Risk: StackOverflowError for very large 'periods' values.
     */
    public double futureValueRecursive(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return futureValueRecursive(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    /**
     * Approach 2: Memoized Recursion
     *
     * Stores previously computed values in a HashMap to avoid redundant calculations.
     * In this linear recursion, memoization doesn't improve time complexity,
     * but demonstrates the technique for problems where subproblems overlap
     * (e.g., Fibonacci, dynamic programming).
     *
     * Time:  O(n) — each period computed once.
     * Space: O(n) — call stack + cache.
     */
    public double futureValueMemoized(double presentValue, double growthRate, int periods,
                                       Map<Integer, Double> memo) {
        if (periods == 0) {
            return presentValue;
        }
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }

        double result = futureValueMemoized(presentValue, growthRate, periods - 1, memo)
                         * (1 + growthRate);
        memo.put(periods, result);
        return result;
    }

    /**
     * Approach 3: Iterative
     *
     * Replaces recursion with a simple loop. Eliminates stack overflow risk.
     *
     * Time:  O(n)
     * Space: O(1) — no recursion, no cache.
     */
    public double futureValueIterative(double presentValue, double growthRate, int periods) {
        double value = presentValue;
        for (int i = 0; i < periods; i++) {
            value *= (1 + growthRate);
        }
        return value;
    }

    /**
     * Approach 4: Direct Formula (Math.pow)
     *
     * FV = PV × (1 + rate) ^ periods
     *
     * Time:  O(1) — Math.pow uses hardware-level exponentiation.
     * Space: O(1)
     */
    public double futureValueFormula(double presentValue, double growthRate, int periods) {
        return presentValue * Math.pow(1 + growthRate, periods);
    }
}
