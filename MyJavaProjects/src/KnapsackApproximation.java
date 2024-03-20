import java.util.Arrays;
import java.util.Comparator;

public class KnapsackApproximation {

    public static void main(String[] args) {
        int[] values = {10, 7, 5, 18, 12};
        int[] weights = {2, 1, 2, 5, 3};
        int capacity = 10;

        double[] valuePerWeight = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            valuePerWeight[i] = (double) values[i] / weights[i];
        }

        // Sort items based on value per weight in descending order using anonymous class
        Integer[] sortedIndices = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            sortedIndices[i] = i;
        }
        Arrays.sort(sortedIndices, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Double.compare(valuePerWeight[b], valuePerWeight[a]);
            }
        });

        int[] solution = new int[values.length];
        int currentWeight = 0;
        int index = 0;
        int totalValue = 0;

        // Greedily fill the knapsack
        while (currentWeight < capacity && index < values.length) {
            int itemIndex = sortedIndices[index];
            if (weights[itemIndex] <= capacity - currentWeight) {
                solution[itemIndex] = weights[itemIndex];  // Include the whole item
                currentWeight += weights[itemIndex];
                totalValue += values[itemIndex];
            } else {
                // Include a fraction of the item to fill the knapsack
                solution[itemIndex] = capacity - currentWeight;
                currentWeight = capacity;  // Knapsack is full
                totalValue += (int) (valuePerWeight[itemIndex] * solution[itemIndex]);
            }
            index++;
        }

        // Print the solution
        System.out.println("Selected items:");
        for (int i = 0; i < values.length; i++) {
            if (solution[i] > 0) {
                System.out.println("Item " + (i + 1) + ": " + solution[i] + " units");
            }
        }
        System.out.println("Total value: " + totalValue);
    }
}