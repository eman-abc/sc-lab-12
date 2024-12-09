import java.util.Arrays;

public class RecursiveBinarySearch {

    // Recursive binary search for integers
    public int binarySearchRecursive(int[] array, int target) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    private int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // Not found
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return binarySearchRecursive(array, target, mid + 1, right);
        } else {
            return binarySearchRecursive(array, target, left, mid - 1);
        }
    }

    // Recursive binary search for strings
    public int binarySearchRecursive(String[] array, String target) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }
        Arrays.sort(array); // Ensure array is sorted
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    private int binarySearchRecursive(String[] array, String target, int left, int right) {
        if (left > right) {
            return -1; // Not found
        }
        int mid = left + (right - left) / 2;
        int comparison = target.compareTo(array[mid]);
        if (comparison == 0) {
            return mid;
        } else if (comparison > 0) {
            return binarySearchRecursive(array, target, mid + 1, right);
        } else {
            return binarySearchRecursive(array, target, left, mid - 1);
        }
    }
}
