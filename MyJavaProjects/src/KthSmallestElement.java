public class KthSmallestElement{
    public static void main(String[] args) {
        int[] array = {29, 15, 7, 2, 18, 31, 11};
        System.out.println("Original Array:");
        printArray(array);
        int thirdSmallest = findThirdSmallest(array);
        System.out.println("\nThird Smallest Element: " + thirdSmallest);
    }
    private static int findThirdSmallest(int[] array) {
        if (array.length < 3) {
            System.out.println("Array should have at least 3 elements.");
            return -1;
        }
// Use a helper method to find the 3rd smallest element
        return findThirdSmallestRecursive(array, 0, array.length - 1, 3);
    }
    private static int findThirdSmallestRecursive(int[] array, int left, int right, int k) {
        if (k > 0 && k <= right - left + 1) {
// Partition the array and get the position of the pivot element
            int pivotIndex = partition(array, left, right);
// Check if the pivot is the k-1 smallest element
            if (pivotIndex - left == k - 1) {
                return array[pivotIndex];
            }
// If pivot is more, search in the left subarray
            if (pivotIndex - left > k - 1) {

                return findThirdSmallestRecursive(array, left, pivotIndex - 1, k);
            }
// Otherwise, search in the right subarray
            return findThirdSmallestRecursive(array, pivotIndex + 1, right, k - pivotIndex + left - 1);
        }
// If k is out of bounds
        return -1;
    }
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }

        System.out.println();
    }
}