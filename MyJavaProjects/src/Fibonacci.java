public class Fibonacci {
    // Memoization
    private static long[] memo;
    // Tabulation
    private static long[] tabulation;
    public static void main(String[] args) {
        int n = 10;
// Memoization
        memo = new long[n + 1];
        long startTimeMemo = System.nanoTime();
        long resultMemo = fibonacciMemo(n);
        long endTimeMemo = System.nanoTime();
        long memoTimeTaken = endTimeMemo -startTimeMemo;
// Tabulation
        tabulation = new long[n + 1];
        long startTimeTabulation = System.nanoTime();
        long resultTabulation = fibonacciTabulation(n);
        long endTimeTabulation = System.nanoTime();
        long tabulationTimeTaken = endTimeTabulation -startTimeTabulation;

        System.out.println("Using Memoization:");
        System.out.println("Fibonacci(" + n + ") = " + resultMemo);
        System.out.println("Time taken: " + memoTimeTaken + " nanoseconds");
        System.out.println("Space complexity: O(n)");

        System.out.println("\nUsing Tabulation:");
        System.out.println("Fibonacci(" + n + ") = " + resultTabulation);
        System.out.println("Time taken: " + tabulationTimeTaken + " nanoseconds");
        System.out.println("Space complexity: O(n)");
    }
    // Memoization
    public static long fibonacciMemo(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        return memo[n];
    }
    // Tabulation
    public static long fibonacciTabulation(int n) {
        tabulation[0] = 0;
        tabulation[1] = 1;
        for (int i = 2; i <= n; i++) {
            tabulation[i] = tabulation[i - 1] + tabulation[i - 2];
        }
        return tabulation[n];
    }
}
