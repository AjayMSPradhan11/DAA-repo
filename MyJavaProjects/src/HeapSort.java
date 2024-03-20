public class HeapSort{
    public static void main(String[] args) {
        int[] array = {55, 12, 42, 8, 31, 66, 24};
        System.out.println("Original Array:");
        printArray(array);
        heapSort(array);
        System.out.println("\nSorted Array:");
        printArray(array);
    }
    private static void heapSort(int[] array) {
        int length = array.length;
// Build heap (rearrange array)
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }
// One by one extract an element from the heap
        for (int i = length - 1; i > 0; i--) {
// Move current root to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
// Call max heapify on the reduced heap
            heapify(array, i, 0);
// Display the array at each step
            System.out.println("Heapify Step " + (length - i) + ":");
            printArray(array);

        }
    }
    private static void heapify(int[] array, int heapSize, int root) {
        int largest = root; // Initialize largest as root
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
// If left child is larger than root
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
// If right child is larger than largestso far
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
// If largest is not root
        if (largest != root) {
// Swap root and largest
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;
// Recursively heapify the affected sub-tree
            heapify(array, heapSize, largest);
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }

        System.out.println();
    }
}