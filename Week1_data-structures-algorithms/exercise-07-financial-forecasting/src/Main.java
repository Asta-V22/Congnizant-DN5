import service.ForecastingService;
import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates financial forecasting using recursive, memoized, iterative,
 * and formula-based approaches.
 */
public class Main {

    public static void main(String[] args) {
        ForecastingService forecast = new ForecastingService();

        double presentValue = 100000.00;  // Initial investment: Rs 1,00,000
        double growthRate = 0.08;          // 8% annual growth
        int periods = 10;                 // 10 years

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.printf("  Present Value:  Rs %.2f%n", presentValue);
        System.out.printf("  Growth Rate:    %.1f%% per year%n", growthRate * 100);
        System.out.printf("  Forecast Period: %d years%n", periods);

        // --- All Four Approaches ---
        System.out.println("\n=== Approach 1: Pure Recursion ===");
        double result1 = forecast.futureValueRecursive(presentValue, growthRate, periods);
        System.out.printf("  Future Value: Rs %.2f%n", result1);

        System.out.println("\n=== Approach 2: Memoized Recursion ===");
        Map<Integer, Double> memo = new HashMap<>();
        double result2 = forecast.futureValueMemoized(presentValue, growthRate, periods, memo);
        System.out.printf("  Future Value: Rs %.2f%n", result2);
        System.out.println("  Cached entries: " + memo.size());

        System.out.println("\n=== Approach 3: Iterative ===");
        double result3 = forecast.futureValueIterative(presentValue, growthRate, periods);
        System.out.printf("  Future Value: Rs %.2f%n", result3);

        System.out.println("\n=== Approach 4: Direct Formula (Math.pow) ===");
        double result4 = forecast.futureValueFormula(presentValue, growthRate, periods);
        System.out.printf("  Future Value: Rs %.2f%n", result4);

        // --- Year-by-year forecast ---
        System.out.println("\n=== Year-by-Year Growth Forecast ===");
        System.out.println("  Year  |  Value");
        System.out.println("  ------+-----------------");
        for (int year = 0; year <= periods; year++) {
            double value = forecast.futureValueFormula(presentValue, growthRate, year);
            System.out.printf("  %-5d | Rs %,.2f%n", year, value);
        }

        // --- Comparison ---
        System.out.println("\n=== Performance Comparison ===");
        System.out.println("  Approach             | Time    | Space   | Stack Safe?");
        System.out.println("  ---------------------+---------+---------+-----------");
        System.out.println("  Pure Recursion       | O(n)    | O(n)    | No");
        System.out.println("  Memoized Recursion   | O(n)    | O(n)    | No");
        System.out.println("  Iterative            | O(n)    | O(1)    | Yes");
        System.out.println("  Direct Formula       | O(1)    | O(1)    | Yes");
    }
}
