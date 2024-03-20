public class MergeSort{
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array:");
        printArray(array);
        mergeSort(array, 0, array.length - 1);
        System.out.println("\nSorted Array:");
        printArray(array);
    }
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
// Find the middle point
            int middle = (left + right) / 2;
// Recursively sort the first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
// Merge the sorted halves
            merge(array, left, middle, right);
        }
    }
    private static void merge(int[] array, int left, int middle, int right) {
// Sizes of the two subarrays to be merged
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

// Create temporary arrays
        int[] leftArray = new int[sizeLeft];
        int[] rightArray = new int[sizeRight];
// Copy data to temporary arrays
        System.arraycopy(array, left, leftArray, 0,sizeLeft);
        System.arraycopy(array, middle + 1, rightArray, 0,sizeRight);
// Merge the temporary arrays
// Initial indices of the subarrays
        int i = 0, j = 0;
// Initial index of the merged subarray
        int k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
// Copy the remaining elements of leftArray[], if there are any
        while (i < sizeLeft) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
// Copy the remaining elements of rightArray[], if there are any
        while (j < sizeRight) {

            array[k] = rightArray[j];
            j++;
            k++;
        }
// Display the array at each merge step
        System.out.println("Merge Step:");
        printArray(array);
    }
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}