/*
JAVA implementation of Randomize QuickSort
using Hoare's Partition
*/
import java.util.*;

class Quicksort
{
    // swap function
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high)
    {
        int rIndex = (low) + (int)(Math.random() * (high - low + 1));

        swap(arr, low, rIndex); // swap low with random index
        int pivot = arr[low];
        int i = low - 1, j = high + 1;

        while (true) {
            // increase i while elements are less than pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // decrease j while elements are greater than pivot
            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;

            swap(arr, i, j);
        }
    }
    // recursive quick sort function
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
            // find partition index
            int p = partition(arr, low, high);
            // sort before and after the pivot
            quickSort(arr, low, p);
            quickSort(arr, p + 1, high);
        }
    }
    // Driver code
    public static void main(String[] args)
    {
        int[] arr = {18, 4, 37, 9, 23, 15, 42};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array : ");
        System.out.print(Arrays.toString(arr));
    }
}