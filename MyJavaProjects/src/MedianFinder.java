import java.util.Random;
import java.util.Scanner;

public class MedianFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int median = findMedian(arr);
        System.out.println("Median: " + median);

        scanner.close();
    }

    public static int findMedian(int[] arr) {
        int n = arr.length;
        if (n % 2 == 0) {
            return quickSelect(arr, n / 2 - 1);
        } else {
            return quickSelect(arr, n / 2);
        }
    }

    public static int quickSelect(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = randomPartition(arr, left, right);
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    public static int randomPartition(int[] arr, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(arr, randomIndex, right);
        return partition(arr, left, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
